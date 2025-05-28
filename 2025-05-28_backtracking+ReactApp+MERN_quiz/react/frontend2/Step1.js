import React from 'react';
import { Button, TextField,  Typography, Card, CardContent, Stack } from '@mui/material';

const Step1 = ({ state, handleChange, dispatch }) => (
  <Card elevation={3} sx={{ maxWidth: 500, margin: 'auto' }}>
    <CardContent>
      <Typography variant="h6" gutterBottom>Step 1: Personal Information</Typography>
      <Stack spacing={2}>
        <TextField label="Name" name="name" value={state.name} onChange={handleChange} fullWidth />
        <TextField label="Email" name="email" value={state.email} onChange={handleChange} fullWidth />
        <TextField label="Phone" name="phone" value={state.phone} onChange={handleChange} fullWidth />
        <Button variant="contained" onClick={() => dispatch({ type: 'NEXT_STEP' })}>Next</Button>
      </Stack>
    </CardContent>
  </Card>
);

export default Step1;