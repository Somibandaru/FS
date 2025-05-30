import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Register() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleRegister = async () => {
    setMessage('');
    setError('');
    console.log('reg button clicked')
    try {
      await axios.post('http://192.168.29.118:4000/api/register', { username, password });
      setMessage('Registration successful.');
      setTimeout(() => navigate('/login'), 1500); // wait 1.5s to show message before redirect
    } catch (err) {
      const msg = err.response?.data?.message || err.message || 'Registration failed.';
      setError('Registration failed: ' + msg);
    }
  };

  return (
    <div className="form-container">
      <h2>Register</h2>

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

      <button onClick={handleRegister}>Register</button>

      {message && <p style={{ color: 'green', marginTop: '15px' }}>{message}</p>}
      {error && <p style={{ color: 'red', marginTop: '15px' }}>{error}</p>}
    </div>
  );
}

export default Register;
