import React from 'react';
import { useNavigate } from 'react-router-dom';

function Navbar() {
  const navigate = useNavigate();
  const isLoggedIn = !!JSON.parse(localStorage.getItem('auth'))?.token;

  const handleLogout = () => {
    localStorage.removeItem('auth');
    navigate('/login');
  };

  return (
    <nav style={{
      backgroundColor: '#1976d2',
      padding: '10px 20px',
      color: 'white',
      display: 'flex',
      justifyContent: 'space-between',
      alignItems: 'center'
    }}>
      <h3 style={{ margin: 0 }}>Product App</h3>
      <div>
        {isLoggedIn ? (
          <button style={navButtonStyle} onClick={handleLogout}>
            LOGOUT
          </button>
        ) : (
          <>
            <button
              style={navLinkButtonStyle}
              onClick={() => navigate('/login')}
            >
              LOGIN
            </button>
            <button
              style={navLinkButtonStyle}
              onClick={() => navigate('/register')}
            >
              REGISTER
            </button>
          </>
        )}
      </div>
    </nav>
  );
}

const navButtonStyle = {
  background: 'transparent',
  color: 'white',
  border: 'none',
  fontWeight: 'bold',
  cursor: 'pointer'
};

const navLinkButtonStyle = {
  ...navButtonStyle,
  marginLeft: 20
};

export default Navbar;
