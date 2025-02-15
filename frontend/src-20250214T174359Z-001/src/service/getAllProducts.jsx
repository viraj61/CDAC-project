const getAllProducts = async () => {
  try {
    const response = await fetch('http://localhost:8080/product/display', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    });

    if (!response.ok) {
      throw new Error('Failed to fetch products');
    }

    const data = await response.json(); // ✅ Wait for JSON parsing
    console.log("Fetched Products:", data);
    return data; 
  } catch (error) {
    console.error('Error fetching products:', error);
    throw error; 
  }
};