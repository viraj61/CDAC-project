import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom"; 

const StoreList = () => {
  const navigate = useNavigate();
  const [product, setProduct] = useState({
    productName: "",
    description: "",
    category: "FRUITS", 
    productImage: null, 
    prize: "",
    quantity: "",
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [successMessage, setSuccessMessage] = useState("");

  const user = JSON.parse(sessionStorage.getItem("user"));
  const userRole = user?.role; 

  useEffect(() => {
    if (userRole !== "SELLER") {
      navigate("/unauthorized");
    }
  }, [userRole, navigate]);

  const categories = [
    "FRUITS", "VEGETABLES", "DAIRY", "CLOTHING", "PANTRY",
    "SNACKS", "PULSES", "MASALA", "BAGS"
  ];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prev) => ({ ...prev, [name]: value }));
  };

  const handleFileChange = (e) => {
    setProduct((prev) => ({ ...prev, productImage: e.target.files[0] }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError(null);
    setSuccessMessage("");

    try {
      const productResponse = await fetch("http://localhost:8080/product", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          productName: product.productName,
          description: product.description,
          category: product.category,
          prize: parseFloat(product.prize),
          quantity: parseInt(product.quantity, 10),
        }),
      });

      if (!productResponse.ok) throw new Error("Failed to insert product");

      const productData = await productResponse.json();
      const productId = productData.productId;

      if (product.productImage) {
        const imageFile = new FormData();
        imageFile.append("imageFile", product.productImage);

        const imageResponse = await fetch(
          `http://localhost:8080/product/${productId}/image`,
          { method: "PUT", body: imageFile }
        );

        if (!imageResponse.ok) throw new Error("Failed to upload image");
      }

      setSuccessMessage("Product added successfully!");
      setProduct({
        productName: "",
        description: "",
        category: "FRUITS",
        productImage: null,
        prize: "",
        quantity: "",
      });

    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container mt-4">
      <h2>Add New Product</h2>
      {error && <div className="alert alert-danger">{error}</div>}
      {successMessage && <div className="alert alert-success">{successMessage}</div>}

      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Product Name</label>
          <input type="text" name="productName" value={product.productName} onChange={handleChange} className="form-control" required />
        </div>

        <div className="mb-3">
          <label className="form-label">Description</label>
          <textarea name="description" value={product.description} onChange={handleChange} className="form-control" required />
        </div>

        <div className="mb-3">
          <label className="form-label">Category</label>
          <select name="category" value={product.category} onChange={handleChange} className="form-select" required>
            {categories.map((cat) => (
              <option key={cat} value={cat}>{cat}</option>
            ))}
          </select>
        </div>

        <div className="mb-3">
          <label className="form-label">Price (₹)</label>
          <input type="number" name="prize" value={product.prize} onChange={handleChange} className="form-control" required />
        </div>

        <div className="mb-3">
          <label className="form-label">Quantity</label>
          <input type="number" name="quantity" value={product.quantity} onChange={handleChange} className="form-control" required />
        </div>

        <div className="mb-3">
          <label className="form-label">Product Image</label>
          <input type="file" onChange={handleFileChange} className="form-control" accept="image/*" />
        </div>

        <button type="submit" className="btn btn-primary" disabled={loading}>
          {loading ? "Submitting..." : "Add Product"}
        </button>
      </form>
    </div>
  );
};

export default StoreList;
