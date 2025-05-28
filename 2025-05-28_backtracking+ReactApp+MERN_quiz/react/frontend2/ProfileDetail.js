import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Typography, Box } from '@mui/material';

const ProfileDetail = () => {
  const { id } = useParams();
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    axios.get(`http://192.168.29.118:3000/profiles/${id}`).then((res) => {
      setProfile(res.data);
    });
  }, [id]);

  if (!profile) return <div>Loading...</div>;

  return (
    <Box p={2}>
      <Typography variant="h4">{profile.name}</Typography>
      <Typography>Email: {profile.email}</Typography>
      <Typography>Phone: {profile.phone}</Typography>
      <Typography>Degree: {profile.degree}</Typography>
      <Typography>Institution: {profile.institution}</Typography>
      <Typography>Year: {profile.year}</Typography>
      <Typography>Interests: {profile.interests}</Typography>
      <Typography>Achievements: {profile.achievements}</Typography>
    </Box>
  );
};

export default ProfileDetail;
