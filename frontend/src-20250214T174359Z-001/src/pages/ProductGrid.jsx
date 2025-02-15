import React, { useEffect, useState } from "react";
import { MDBContainer, MDBRow } from "mdb-react-ui-kit";
import Home from "./Home";

function ProductGrid() {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await fetch("http://localhost:8080/product/display", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
          console.log(response);
        if (!response.ok) {
          throw new Error("Failed to fetch products");
        }

        const data = await response.json();

        // Transform data to match expected structure
        const formattedProducts = data.map((item) => ({
          productId: item.productId, 
          productName: item.productName, 
          productImage: item.productImage, 
          quantity: item.quantity,
          category: item.category,
          description: item.description,
          createdAt: item.createdAt, 
          updatedAt: item.updatedAt, 
          prize: item.price || item.prize, // Handle both "prize" & "price"

          // Handle missing seller data safely
          seller: item.users
            ? {
                userId: item.users.userId,
                name: item.users.name,
                email: item.users.email,
                profilePicture: item.users.profilePicture,
              }
            : null,
        }));

        console.log("Fetched Products:", formattedProducts);
        setProducts(formattedProducts);
      } catch (error) {
        console.error("Error fetching products:", error);
        setError(error.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  if (loading) {
    return <div>Loading products...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  return (
    <MDBContainer>
      <MDBRow>
        {products.map((product) => (
          <Home key={product.productId} product={product} />
        ))}
      </MDBRow>
    </MDBContainer>
  );
}

export default ProductGrid;
