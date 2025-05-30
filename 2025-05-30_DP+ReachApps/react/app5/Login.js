import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const res = await axios.post('http://192.168.29.118:4000/api/login', { username, password });
      localStorage.setItem('auth', JSON.stringify({ token: res.data.token }));
      
      navigate('/products');
    } catch (err) {
      alert('Login failed. Please try again.');
    }
  };

  return (
    <div className="form-container">
      <h2>Login</h2>

      <div style={{ textAlign: 'left', marginBottom: '10px' }}>
        <label htmlFor="username">Username</label>
        <input
          id="username"
          type="text"
          value={username}
          onChange={e => setUsername(e.target.value)}
        />
      </div>

      <div style={{ textAlign: 'left', marginBottom: '10px' }}>
        <label htmlFor="password">Password</label>
        <input
          id="password"
          type="password"
          value={password}
          onChange={e => setPassword(e.target.value)}
        />
      </div>

      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;
