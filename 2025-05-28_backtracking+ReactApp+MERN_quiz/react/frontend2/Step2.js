import React from 'react';
import { Button, TextField, Box, Typography, Card, CardContent, Stack } from '@mui/material';

const Step2 = ({ state, handleChange, dispatch }) => (
  <Card elevation={3} sx={{ maxWidth: 500, margin: 'auto' }}>
    <CardContent>
      <Typography variant="h6" gutterBottom>Step 2: Education Information</Typography>
      <Stack spacing={2}>
        <TextField label="Degree" name="degree" value={state.degree} onChange={handleChange} fullWidth />
        <TextField label="Institution" name="institution" value={state.institution} onChange={handleChange} fullWidth />
        <TextField label="Year" name="year" value={state.year} onChange={handleChange} fullWidth />
        <Box display="flex" justifyContent="space-between">
          <Button onClick={() => dispatch({ type: 'PREV_STEP' })}>Back</Button>
          <Button variant="contained" onClick={() => dispatch({ type: 'NEXT_STEP' })}>Next</Button>
        </Box>
      </Stack>
    </CardContent>
  </Card>
);

export default Step2;
