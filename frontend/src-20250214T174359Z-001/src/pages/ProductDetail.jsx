import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { AiOutlineHeart } from "react-icons/ai";
import { BiShoppingBag } from "react-icons/bi";

const ProductDetail = () => {
  const { id } = useParams(); // Get product ID from URL
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const response = await fetch(`http://localhost:8080/product/${id}`);
        if (!response.ok) throw new Error("Failed to fetch product details");
        const data = await response.json();
        setProduct(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProduct();
  }, [id]);

  // Function to add product to cart (Stored in LocalStorage)
  const addToCart = () => {
    if (!product) return;
    let cart = JSON.parse(localStorage.getItem("cart")) || [];
    if (cart.some((item) => item.id === product.id)) {
      alert(`${product.productName} is already in the cart!`);
    } else {
      cart.push(product);
      localStorage.setItem("cart", JSON.stringify(cart));
      alert(`${product.productName} added to cart!`);
    }
  };

  // Function to add product to wishlist (Stored in SessionStorage)
  const addToWishlist = () => {
    if (!product) return;
  
    // Retrieve existing wishlist from sessionStorage or initialize an empty array
    let wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];
  
    // Check if the product is already in the wishlist
    if (wishlist.some((item) => item.id === product.id)) {
      alert(`${product.productName} is already in the wishlist!`);
    } else {
      wishlist.push(product); // Add new product to wishlist array
      sessionStorage.setItem("wishlist", JSON.stringify(wishlist)); // Update sessionStorage
      alert(`${product.productName} added to wishlist!`);
    }
  
    console.log("Updated Wishlist:", wishlist); // Debugging to check stored data
  };
  
  

  if (loading) return <p className="text-center text-gray-600">Loading product...</p>;
  if (error) return <p className="text-center text-red-500">Error: {error}</p>;
  if (!product) return <p className="text-center text-gray-600">Product not found</p>;

  const imageUrl = `http://localhost:8080/product/${product.productId}/image`;
  console.log(imageUrl);

  return (
    <div className="container mx-auto p-6 max-w-2xl shadow-lg border rounded-lg relative">
      {/* Product ID in the Top-Right Corner */}
      <div className="absolute top-2 right-2 bg-gray-900 text-white text-xs px-3 py-1 rounded-lg">
        ID: {product.id}
      </div>

      {/* Product Image */}
      <img src={imageUrl} alt={product.productName} className="w-full h-80 object-cover rounded-lg" />

      {/* Product Details */}
      <div className="mt-4">
        <h1 className="text-3xl font-bold">{product.product_name }</h1>
        <p className="text-gray-500">{product.description}</p>

        <p className="text-lg font-semibold mt-2">
          Price: <span className="text-red-600"> Rs {product.price}</span>
        </p>
        <p className="text-sm mt-1">
          Available: <span className="text-green-600">{product.availableUnit} {product.unit}</span>
        </p>
        <p className="text-sm mt-1">
          Colour: <span className="font-medium">{product.metadata?.colour || "N/A"}</span>
        </p>
      </div>

      {/* Buttons */}
      <div className="mt-6 flex space-x-4">
        <button 
          className="flex items-center px-6 py-3 bg-red-600 text-white rounded-lg hover:bg-red-700"
          onClick={addToCart}
        >
          <BiShoppingBag className="mr-2" /> Add to Cart
        </button>

        <button 
          className="flex items-center px-6 py-3 bg-blue-600 text-white rounded-lg hover:bg-blue-700"
          onClick={addToWishlist}
        >
          <AiOutlineHeart className="mr-2" /> Wishlist
        </button>
      </div>
    </div>
  );
};

export default ProductDetail;
