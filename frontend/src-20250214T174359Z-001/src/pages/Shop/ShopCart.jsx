import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const ShopCart = () => {
  const [cart, setCart] = useState([]);
  const navigate = useNavigate();

  // Load cart from localStorage and ensure valid quantity and price
  useEffect(() => {
    const storedCart = JSON.parse(localStorage.getItem("cart")) || [];

    // Ensure each item has valid properties
    const updatedCart = storedCart.map((item) => ({
      ...item,
      quantity: item.quantity && item.quantity > 0 ? item.quantity : 1, // Default quantity = 1
      price: item.price ? item.price : 100, // Default price = ₹100
      imageUrl: item.imageUrl || `http://localhost:9090/store/${item.storeId}/product/${item.id}/image`, // Fallback image
      description: item.description || "No description available", // Fallback description
    }));

    setCart(updatedCart);
    localStorage.setItem("cart", JSON.stringify(updatedCart)); // Update localStorage if needed
  }, []);

  const updateCart = (updatedCart) => {
    setCart(updatedCart);
    localStorage.setItem("cart", JSON.stringify(updatedCart));
  };

  const removeFromCart = (id) => {
    const updatedCart = cart.filter((item) => item.id !== id);
    updateCart(updatedCart);
  };

  const changeQuantity = (id, amount) => {
    const updatedCart = cart.map((item) =>
      item.id === id
        ? { ...item, quantity: Math.max(1, item.quantity + amount) } // Ensure quantity is at least 1
        : item
    );
    updateCart(updatedCart);
  };

  const getTotalPrice = () => {
    return cart.reduce((total, item) => total + item.price * item.quantity, 0).toFixed(2);
  };

  const handleCheckout = () => {
    navigate("/MyAcconutPaymentMethod");
  };

  return (
    <div className="container mx-auto p-6 max-w-3xl">
      <h1 className="text-3xl font-bold mb-4">Shopping Cart</h1>

      {cart.length === 0 ? (
        <p className="text-gray-500">
          Your cart is empty. <Link to="/" className="text-violet-700">Shop now</Link>
        </p>
      ) : (
        <>
          {cart.map((item) => (
            <div key={item.id} className="flex items-center border-b py-4">
              {/* Product Image */}
              {/* <img 
                src={item.imageUrl} 
                alt={item.productName} 
                className="w-24 h-24 object-cover rounded-lg" 
              /> */}
          <img 
  src={item.imageUrl} 
  alt={item.productName} 
  className="w-24 h-24 object-cover rounded-lg"
/>



              {/* Product Details */}
              <div className="ml-4 flex-grow">
                <h2 className="text-xl font-semibold">{item.productName}</h2>
                <p className="text-gray-600 text-sm">{item.description}</p> {/* Description */}
                <p className="text-gray-500">₹{item.price} each</p> {/* Price */}

                {/* Quantity Control */}
                <div className="flex items-center mt-2">
  <button 
    className="bg-gray-300 w-8 h-8 flex items-center justify-center rounded-lg text-lg font-bold" 
    onClick={() => changeQuantity(item.id, -1)}
  >
    −
  </button>
  <span className="mx-4 text-lg">{item.quantity}</span>
  <button 
    className="bg-gray-300 w-8 h-8 flex items-center justify-center rounded-lg text-lg font-bold" 
    onClick={() => changeQuantity(item.id, 1)}
  >
    +
  </button>
</div>
              </div>

              {/* Remove Button */}
              <button 
                className="bg-red-500 text-white px-3 py-1 rounded-lg hover:bg-red-600 ml-4"
                onClick={() => removeFromCart(item.id)}
              >
                Remove
              </button>
            </div>
          ))}

          {/* Total Price */}
          <div className="mt-6 text-xl font-bold">
            Total: <span className="text-violet-700">₹{getTotalPrice()}</span>
          </div>

          {/* Checkout Button */}
          <button 
            className="mt-4 bg-green-600 text-white px-6 py-2 rounded-lg hover:bg-green-700"
            onClick={handleCheckout}
          >
            Proceed to Checkout
          </button>
        </>
      )}
    </div>
  );
};

export default ShopCart;
