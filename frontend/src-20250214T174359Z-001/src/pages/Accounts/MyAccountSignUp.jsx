import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const SignUp = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    phone: "",
    password: "",
    confirmPassword: "",
    groupId: "",
    role: "CUSTOMER", // Default role
  });

  const [error, setError] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (formData.password !== formData.confirmPassword) {
      setError("Passwords do not match!");
      return;
    }
    setError("");

    // Prepare final JSON object
    const { confirmPassword, ...userData } = formData; // Exclude confirmPassword before sending

    try {
      const response = await fetch("http://localhost:8080/user", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(userData),
      });

      if (!response.ok) {
        throw new Error("Registration failed!");
      }

      const result = await response.json();
      console.log("User registered successfully:", result);
      alert("Registration successful!");
    } catch (error) {
      console.error("Error registering user:", error);
      alert("Error during registration. Please try again.");
    }
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center">Register</h2>
      <form onSubmit={handleSubmit} className="w-50 mx-auto border p-4 rounded shadow">
        
        <div className="mb-3">
          <label className="form-label">Full Name</label>
          <input type="text" className="form-control" name="name" value={formData.name} onChange={handleChange} required />
        </div>

        {/* <div className="mb-3">
          <label className="form-label">Email</label>
          <input type="email" className="form-control" name="email" value={formData.email} onChange={handleChange} required />
        </div> */}


<div className="mb-3">
  <label className="form-label">Email</label>
  <input
    type="email"
    className="form-control"
    name="email"
    value={formData.email}
    onChange={handleChange}
    pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
    title="Enter a valid email address (e.g., user@example.com)"
    required
  />
</div>


        {/* <div className="mb-3">
          <label className="form-label">Phone Number</label>
          <input type="number" className="form-control" maxLength={10} minLength={10} name="phone" value={formData.phone} onChange={handleChange} required />
        </div> */}


<div className="mb-3">
  <label className="form-label">Phone Number</label>
  <input
    type="text"
    className="form-control"
    name="phone"
    value={formData.phone}
    onChange={handleChange}
    onInput={(e) => e.target.value = e.target.value.replace(/\D/g, '')} // Allow only numbers
    pattern="^[6-9]\d{9}$" // Starts with 6-9 and has 10 digits
    title="Phone number must be 10 digits and start with 6-9"
    required
  />
</div>


        <div className="mb-3">
          <label className="form-label">Password</label>
          <input type="password" className="form-control" name="password" value={formData.password} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Confirm Password</label>
          <input type="password" className="form-control" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} required />
          {error && <p className="text-danger mt-1">{error}</p>}
        </div>

        <div className="mb-3">
          <label className="form-label">Group ID</label>
          <input type="number" className="form-control" name="groupId" value={formData.groupId} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Role</label>
          <select className="form-control" name="role" value={formData.role} onChange={handleChange}>
            <option value="CUSTOMER">Customer</option>
            <option value="SELLER">Seller</option>
          </select>
        </div>

        <button type="submit" className="btn btn-primary w-100">Register</button>
      </form>
    </div>
  );
};

export default SignUp;
