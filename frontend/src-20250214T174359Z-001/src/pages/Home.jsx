import * as React from "react";
import { useNavigate } from "react-router-dom";
import AspectRatio from "@mui/joy/AspectRatio";
import Button from "@mui/joy/Button";
import Card from "@mui/joy/Card";
import CardContent from "@mui/joy/CardContent";
import CardOverflow from "@mui/joy/CardOverflow";
import Typography from "@mui/joy/Typography";
import Link from "@mui/joy/Link";
import ArrowOutwardIcon from "@mui/icons-material/ArrowOutward";

export default function Home({ product }) {
  const navigate = useNavigate();
  console.log(product.productId);
  if (!product) return <Typography>Product not found</Typography>;

  // Construct image URL
  const imageUrl = product.productImage
    ? `http://localhost:8080/product/${product.productId}/image`
    : "https://via.placeholder.com/150";

  // Handle product navigation
  const handleNavigation = () => {
    navigate(`/productdetail/${product.productId}`);
  };

  // Handle Add to Cart
  const addToCart = () => {
    let cart = JSON.parse(localStorage.getItem("cart")) || [];
  
    const existingProduct = cart.find((item) => item.id === product.productId);
  
    if (existingProduct) {
      alert(`${product.product_name} is already in the cart!`);
    } else {
      const productToAdd = {
        id: product.productId, // Changed to match cart structure
        productName: product.product_name,
        price: product.price || 100, // Use actual price or default ₹100
        quantity: 1, // Default quantity
        imageUrl: imageUrl, // Use image URL
        description: product.description || "No description available",
        storeId: product.storeId || "Unknown Store",
      };
  
      cart.push(productToAdd);
      localStorage.setItem("cart", JSON.stringify(cart));
      alert(`${product.product_name} added to cart!`);
    }
  };
  

  return (
    <div className="col-md-4 mb-4">
      <Card sx={{ width: 320, maxWidth: "100%", boxShadow: "lg", position: "relative" }}>
        {/* Product ID Badge */}
        <Typography
          sx={{
            position: "absolute",
            top: 8,
            right: 8,
            backgroundColor: "#ff6b6b",
            color: "white",
            fontSize: "12px",
            padding: "4px 8px",
            borderRadius: "4px",
          }}
        >
          ID: {product.product_id}
        </Typography>

        {/* Product Image */}
        <CardOverflow>
          <AspectRatio sx={{ minWidth: 200 }}>
            <img src={imageUrl} alt={product.product_name} loading="lazy" />
          </AspectRatio>
        </CardOverflow>

        <CardContent>
          {/* Product Category */}
          <Typography level="body-xs">{product.category || "No Category"}</Typography>

          {/* Product Name with Navigation */}
          <Link
            component="button"
            onClick={handleNavigation}
            color="neutral"
            textColor="text.primary"
            overlay
            endDecorator={<ArrowOutwardIcon />}
            sx={{ fontWeight: "md" }}
          >
            {product.product_name}
          </Link>

          {/* Product Description */}
          <Typography level="body-sm" sx={{ mt: 1 }}>
            {product.description || "No description available"}
          </Typography>

          {/* Available Units */}
          <Typography level="body-sm" sx={{ mt: 1, color: "green" }}>
            Available: <b>{product.quantity || 0}</b> in stock
          </Typography>

          {/* Product Price (Default ₹100) */}
          <Typography level="body-md" sx={{ mt: 1, color: "blue", fontWeight: "bold" }}>
            Price: ₹{product.prize || 100}
          </Typography>
        </CardContent>

        {/* Add to Cart Button */}
        <CardOverflow>
          <Button variant="solid" color="danger" size="lg" onClick={addToCart}>
            Add to Cart
          </Button>
        </CardOverflow>
      </Card>
    </div>
  );
}
