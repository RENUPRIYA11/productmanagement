import React from 'react';
import Header from './components/Header';
import ProductList from './components/ProductList';
import { CartProvider } from './context/CartContext'; // Make sure path is correct
import './App.css';

function App() {
  return (
    <CartProvider>
      <div className="App">
        <Header />
        <ProductList />
      </div>
    </CartProvider>
  );
}

export default App;
