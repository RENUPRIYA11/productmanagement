// src/components/ProductForm.jsx
import React, { useState, useEffect } from 'react';
import { createProduct, updateProduct } from '../services/api';
import './ProductForm.css';

const ProductForm = ({ onAdd, onClose, editableProduct }) => {
  const [product, setProduct] = useState({
    id: '',
    name: '',
    description: '',
    price: '',
    stock: '',
    image_url: '',
  });

  useEffect(() => {
    if (editableProduct) {
      setProduct(editableProduct);
    }
  }, [editableProduct]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct({ ...product, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editableProduct) {
        await updateProduct(product.id, product);
      } else {
        await createProduct(product);
      }
      onAdd();
      onClose();
    } catch (error) {
      console.error('Error while submitting product:', error);
      alert('Failed to add product. Please check your backend and input data.');
    }
  };

  return (
    <div className="modal">
      <div className="modal-content">
        <h3>{editableProduct ? '✏️ Edit Product' : '➕ Add Product'}</h3>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="id"
            value={product.id}
            onChange={handleChange}
            placeholder="ID"
            required
          />
          <input
            type="text"
            name="name"
            value={product.name}
            onChange={handleChange}
            placeholder="Name"
            required
          />
          <input
            type="text"
            name="description"
            value={product.description}
            onChange={handleChange}
            placeholder="Description"
            required
          />
          <input
            type="number"
            name="price"
            value={product.price}
            onChange={handleChange}
            placeholder="Price"
            required
          />
          <input
            type="number"
            name="stock"
            value={product.stock}
            onChange={handleChange}
            placeholder="Stock"
            required
          />
          <input
            type="text"
            name="image_url"
            value={product.image_url}
            onChange={handleChange}
            placeholder="Image filename (e.g., iPhone14.jpg)"
            required
          />
          <div className="modal-buttons">
            <button type="submit">{editableProduct ? 'Update' : 'Add'}</button>
            <button type="button" onClick={onClose}>Cancel</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ProductForm;
