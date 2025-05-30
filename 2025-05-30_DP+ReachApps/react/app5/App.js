import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate, Outlet } from 'react-router-dom';
import Login from './Login';
import Register from './Register';
import ProductTable from './Product';
import Navbar from './Navbar';

const isAuthenticated = () => {
  try {
    const auth = JSON.parse(localStorage.getItem('auth'));
    return !!auth?.token;
  } catch {
    return false;
  }
};

const PrivateRoute = () => {
  return isAuthenticated() ? <Outlet /> : <Navigate to="/login" />;
};

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Navigate to={isAuthenticated() ? '/products' : '/login'} />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />

        <Route element={<PrivateRoute />}>
          <Route path="/products" element={<ProductTable />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
