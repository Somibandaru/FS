import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import MultiStepForm from './MultiStepForm';
import ProfilesList from './ProfilesList';
import ProfileDetail from './ProfileDetail';
import { AppBar, Toolbar, Typography, Button, Container } from '@mui/material';

function App() {
  return (
    <Router>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" sx={{ flexGrow: 1 }}>Profile Manager</Typography>
          <Button color="inherit" component={Link} to="/">New Profile</Button>
          <Button color="inherit" component={Link} to="/profiles">All Profiles</Button>
        </Toolbar>
      </AppBar>
      <Container sx={{ mt: 4 }}>
      <Routes>
        <Route path="/" element={<MultiStepForm />} />
        <Route path="/profiles" element={<ProfilesList />} />
        <Route path="/profiles/:id" element={<ProfileDetail />} />
      </Routes>
      </Container>
    </Router>
  );
}

export default App;
