import { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const UserEditPage = () => {
  const [formData, setFormData] = useState({
    userId: "",
    name: "",
    email: "",
    groupId: "",
    role: "CUSTOMER",
    phoneNumber: "", // Add phone number to state
  });

  const [errors, setErrors] = useState({});

  useEffect(() => {
    const storedUserData = sessionStorage.getItem("user");
    if (storedUserData) {
      setFormData(JSON.parse(storedUserData));
    } else {
      console.error("No user data found in session storage.");
    }
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
    setErrors({ ...errors, [name]: "" }); // Clear previous errors

    switch (name) {
      case "phoneNumber":
        const numericValue = value.replace(/\D/g, ''); // Only digits
        setFormData({ ...formData, [name]: numericValue }); // Update with numeric value
        setErrors(prevErrors => ({...prevErrors, [name]: numericValue.length === 10 ? "" : "Phone number must be 10 digits"}));
        break;
      case "email":
        const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        setErrors(prevErrors => ({...prevErrors, [name]: emailRegex.test(value) ? "" : "Invalid email format"}));
        break;
      case "groupId":
        const groupIdRegex = /^\d*$/;
        if (!groupIdRegex.test(value)) return; // Prevent non-numeric input

        if (formData.role !== "CUSTOMER") {
          setErrors(prevErrors => ({...prevErrors, [name]: value.length === 10 ? "" : "Group ID must be 10 digits"}));
        }
        break;
      case "name":
        if (value.length < 3 || value.length > 50) {
          setErrors(prevErrors => ({...prevErrors, [name]: "Name must be between 3 and 50 characters"}));
        } else if (!/^[A-Za-z\s]+$/.test(value)) {
          setErrors(prevErrors => ({...prevErrors, [name]: "Name should only contain letters and spaces"}));
        }
        break;
      default:
        break;
    }
  };


  const handleSubmit = async (e) => {
    e.preventDefault();

    if (Object.values(errors).some(error => error)) {
      alert("Please correct the errors before submitting.");
      return;
    }

    try {
      const response = await fetch(`http://localhost:8080/user/${formData.userId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.message || "Failed to update user");
      }

      alert("User updated successfully!");
      sessionStorage.setItem("user", JSON.stringify(formData));
    } catch (err) {
      console.error("Error updating user:", err);
      alert(err.message || "Error updating user. Please try again.");
    }
  };

  return (
    <div className="container mt-5">
      {/* ... other code (form structure) ... */}

      <div className="mb-3">
        <label className="form-label">Phone Number</label>
        <input
          type="text"
          className="form-control"
          name="phoneNumber"
          value={formData.phoneNumber}
          onChange={handleChange}
          required
          maxLength="10" // Important: Limit input to 10 digits
        />
        {errors.phoneNumber && <div className="text-danger">{errors.phoneNumber}</div>}
      </div>

      {/* ... rest of the form ... */}
    </div>
  );
};

export default UserEditPage;