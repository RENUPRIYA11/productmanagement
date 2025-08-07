import React, { useEffect, useState } from 'react';
import { getAllProducts, deleteProduct } from '../services/api';
import imageMap from '../assets/imageMap';
import './ProductList.css';
import ProductForm from './ProductForm';



const ProductList = () => {
  const [products, setProducts] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [editingProduct, setEditingProduct] = useState(null);
  const [searchQuery, setSearchQuery] = useState('');
  
  const fetchProducts = () => {
    getAllProducts()
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error('Error while getting product list:', error);
      });
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  const handleDelete = (id) => {
    if (window.confirm('Are you sure you want to delete this product?')) {
      deleteProduct(id)
        .then(() => fetchProducts())
        .catch((error) => {
          console.error('Failed to delete:', error);
        });
    }
  };

  const handleEdit = (product) => {
    setEditingProduct(product);
    setShowForm(true);
  };

  const filteredProducts = products.filter((product) =>
    product.name.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <div className="product-container">
      <h2>🛍️ Product Management</h2>

      <div className="product-actions">
        <input
          type="text"
          placeholder="🔍 Search products..."
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
          className="search-input"
        />
        <button
          onClick={() => {
            setEditingProduct(null);
            setShowForm(true);
          }}
          className="add-button"
        >
          ➕ Add Product
        </button>
      </div>

      {showForm && (
        <ProductForm
          product={editingProduct}
          onClose={() => setShowForm(false)}
          onAdd={fetchProducts}
        />
      )}

      <div className="product-list">
        {filteredProducts.length === 0 ? (
          <p>🔎 No products found.</p>
        ) : (
          filteredProducts.map((product) => (
            <div className="product-card" key={product.id}>
              <img
                src={imageMap[product.image_url]}
                alt={product.name}
                className="product-image"
              />
              <h3>{product.name}</h3>
              <p>{product.description}</p>
              <p><strong>₹{product.price}</strong></p>
              <p>Stock: {product.stock}</p>
              <div className="product-buttons">
                <button
                  onClick={() => handleEdit(product)}
                  className="edit-button"
                >
                  ✏️ Edit
                </button>
                <button
                  onClick={() => handleDelete(product.id)}
                  className="delete-button"
                >
                  🗑️ Delete
                </button>
                
              </div>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default ProductList;
