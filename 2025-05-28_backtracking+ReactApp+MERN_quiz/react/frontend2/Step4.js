import React from 'react';
import { Button, TextField, Box, Typography, Card, CardContent, Stack } from '@mui/material';

const Step4 = ({ state, handleChange, dispatch, handleSubmit }) => (
  <Card elevation={3} sx={{ maxWidth: 500, margin: 'auto' }}>
    <CardContent>
      <Typography variant="h6" gutterBottom>Step 4: Achievements</Typography>
      <Stack spacing={2}>
        <TextField label="Achievements (comma-separated)" name="achievements" value={state.achievements} onChange={handleChange} fullWidth />
        <Box display="flex" justifyContent="space-between">
          <Button onClick={() => dispatch({ type: 'PREV_STEP' })}>Back</Button>
          <Button variant="contained" onClick={handleSubmit}>Submit</Button>
        </Box>
      </Stack>
    </CardContent>
  </Card>
);

export default Step4;
