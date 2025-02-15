export const updateUserProfile = async (id, obj) => {
  console.log("Sending request with ID:", id); // Debugging log

  const response = await fetch(`http://localhost:8080/user/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(obj),
  });

  if (!response.ok) {
    throw new Error('Failed to update profile');
  }

  return response.json();
};
