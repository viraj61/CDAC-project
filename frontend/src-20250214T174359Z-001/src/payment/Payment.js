// import React, { useState, useEffect } from 'react';
// import axios from 'axios';
// import { useNavigate, useParams } from 'react-router-dom';

// const Payment = () => {
//     const { userId } = useParams();
//     const navigate = useNavigate();
//     const [loading, setLoading] = useState(false);
//     const [error, setError] = useState(null);
//     const [user, setUser] = useState(null);
//     const[response, setResponse] = useState(null);
//     const [razorpayLoaded, setRazorpayLoaded] = useState(false); // Track script load

//     useEffect(() => {
//         // 1. Load Razorpay script (most robust method):
//         const loadRazorpayScript = () => {
//             const script = document.createElement('script');
//             script.src = 'https://checkout.razorpay.com/v1/checkout.js';
//             script.async = true;
//             script.onload = () => setRazorpayLoaded(true);
//             script.onerror = () => console.error("Razorpay script load failed");
//             document.body.appendChild(script);
//         };

//         if (!window.Razorpay) { // Check if Razorpay is already loaded
//             loadRazorpayScript();
//         } else {
//             setRazorpayLoaded(true);
//         }
//         return () => {
//             const script = document.querySelector('script[src*="razorpay"]');
//             if (script) {
//                 script.remove();
//             }
//         };
//     }, []); // Empty dependency array ensures this runs only once
//     const handlePayment = async () => {
//         if (!razorpayLoaded) {  // Very important!
//             console.error("Razorpay not yet loaded!");
//             setError("Razorpay is not loaded. Please try again."); // User-friendly message
//             return;
//         }

//         setLoading(true);
//         setError(null);

//         try {
//             // const response = await axios.post(`http://localhost:8080/payment/display`, {
//             //     amount: 10,  // Replace with actual amount!
//             //     subscriptionType: "Monthly" // Replace as needed!
//             // });
//             // console.log(userId);
            
//             // console.log("Payment Response from backend:", response.data);

//             const options = {
//                 key: "rzp_test_9ixpsXiv2GQ9fC", // Ensure this env variable is set!
//                 amount: 500,
//                 currency: 'INR',
//                 name: 'Krushi Market',
//                 description: 'Subscription Payment',
//                 order_id: 589045,
//                 handler: 
//                 async function (response) {
//                 //     try {
//                 //         const verificationResponse = await axios.post('http://localhost:8080/payment/verify', response);
//                 //         console.log("Payment Verification Successful", verificationResponse.data);
//                 //         navigate('/confirmation');
//                 //     } catch (error) {
//                 //         console.error("Payment Verification Failed", error.response?.data || error.message);
//                 //         setError("Payment verification failed. Please try again.");
//                     // }
//                 },
//                 prefill: {
//                     name: user?.name,
//                     email: user?.email,
//                     contact: user?.phone,
//                 },
//                 notes: {
//                     address: user?.location,
//                 },
//                 theme: {
//                     color: '#3399cc'
//                 }
//             };

//             const rzp1 = new window.Razorpay(options);
//             rzp1.open();

//             rzp1.on('payment.failed', function (response) {
//                 console.error("Razorpay payment failed:", response);
//                 alert(response.error.description);
//                 setError(response.error.description);
//             });

//         } catch (error) {
//             console.error("Payment Error:", error.response?.data || error.message);
//             setError(error.response?.data?.message || "An error occurred during payment.");
//         } finally {
//             setLoading(false);
//         }
//     };

//     return (
//         <div className="payment-container">
//             <h2>Payment</h2>
//             {error && <div className="error-message">{error}</div>}
//             {loading ? (
//                 <p>Loading...</p>
//             ) : (
//                 <button onClick={handlePayment} disabled={!razorpayLoaded}> {/* Disable if not loaded */}
//                     {razorpayLoaded ? "Pay Now" : "Loading Razorpay..."} {/* Show loading message */}
//                 </button>
//             )}
//         </div>
//     );
// };

// export default Payment;














import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

const Payment = () => {
  const { userId } = useParams();
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [razorpayLoaded, setRazorpayLoaded] = useState(false);
  const [isProcessingPayment, setIsProcessingPayment] = useState(false);
  const [isBookingConfirmed, setIsBookingConfirmed] = useState(false);
  const [item, setItem] = useState(null); // State to hold item details

  useEffect(() => {
    // Fetch item details (replace with your actual API call)
    const fetchItemDetails = async () => {
      try {
        const response = await axios.post(
          "http://localhost:8080/payment",
          {
            transactionId: 1,
            paymentGateway: "Razorpay",
            Status: "Success",
            Amount: 599.00,
            Paymentdate: new Date().toISOString(), // Use ISO 8601 format for date
          },
          {
            headers: { "Content-Type": "application/json" },
          }
        );
        setItem(response.data);
      } catch (err) {
        console.error("Error fetching item details:", err);
        setError("Failed to load item details.");
      }
    };

    fetchItemDetails(); // Fetch on component mount

    // Load Razorpay script (dynamic loading)
    const loadRazorpayScript = () => {
      const script = document.createElement("script");
      script.src = "https://checkout.razorpay.com/v1/checkout.js";
      script.async = true;
      script.onload = () => setRazorpayLoaded(true);
      script.onerror = () => {
        console.error("Razorpay script load failed");
        setError("Failed to load payment gateway.");
      };
      document.body.appendChild(script);
    };

    if (!window.Razorpay) {
      loadRazorpayScript();
    } else {
      setRazorpayLoaded(true);
    }

    return () => {
      const script = document.querySelector('script[src*="razorpay"]');
      if (script) {
        script.remove();
      }
    };
  },);

  const handleclickOfCard = () => {
    if (!item) {
      // Check if item details are loaded
      setError("Item details not loaded yet.");
      return;
    }

    if (!razorpayLoaded) {
      setError("Razorpay is not loaded. Please try again.");
      return;
    }

    var options = {
      key: "rzp_test_ILnuVxztFBgq6h", // Replace with your actual key
      currency: "INR",
      amount: item.rent * 100, // Access rent from item object
      name: item.name, // Access name from item object
      description: item.owner, // Access owner from item object
      handler: function (response) {
        setIsProcessingPayment(true);
        setTimeout(() => {
          setIsProcessingPayment(false);
          setIsBookingConfirmed(true);
          // onConfirm(); // If you have an onConfirm function
          navigate("/booking-success", {
            state: { message: "Booking successful!" },
          });
        }, 1000);
      },
      prefill: {
        name: "BookYourStay", // Replace with user data if available
        email: "rafikshaikh10699@gmail.com", // Replace with user data if available
        contact: "9370971534", // Replace with user data if available
      },
      notes: {
        address: "IACSD CDAC pune, Maharastra", // Replace with user data if available
      },
      theme: {
        color: "#3399cc",
      },
    };

    var pay = new window.Razorpay(options);
    pay.open();
  };

  if (!item) {
    return <div>Loading item details...</div>; // Display loading message while fetching item details
  }

  return (
    <div className="payment-container">
      <h2>Payment</h2>
      {error && <div className="error-message">{error}</div>}
      {loading? (
        <p>Loading...</p>
      ): (
        <button
          onClick={handleclickOfCard}
          disabled={isProcessingPayment ||!razorpayLoaded}
        >
          {isProcessingPayment
          ? "Processing..."
          : razorpayLoaded
          ? "Pay Now"
          : "Loading Razorpay..."}
        </button>
      )}
    </div>
  );
};

export default Payment;