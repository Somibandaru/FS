import React from 'react';
import { Button, TextField, Box, Typography, Card, CardContent, Stack } from '@mui/material';

const Step3 = ({ state, handleChange, dispatch }) => (
  <Card elevation={3} sx={{ maxWidth: 500, margin: 'auto' }}>
    <CardContent>
      <Typography variant="h6" gutterBottom>Step 3: Interests</Typography>
      <Stack spacing={2}>
        <TextField label="Interests (comma-separated)" name="interests" value={state.interests} onChange={handleChange} fullWidth />
        <Box display="flex" justifyContent="space-between">
          <Button onClick={() => dispatch({ type: 'PREV_STEP' })}>Back</Button>
          <Button variant="contained" onClick={() => dispatch({ type: 'NEXT_STEP' })}>Next</Button>
        </Box>
      </Stack>
    </CardContent>
  </Card>
);

export default Step3;