import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { List, ListItem, ListItemText, Typography } from '@mui/material';
import { Link } from 'react-router-dom';

const ProfilesList = () => {
  const [profiles, setProfiles] = useState([]);

  useEffect(() => {
    axios.get('http://192.168.29.118:3000/profiles').then((res) => {
      setProfiles(res.data);
    });
  }, []);

  return (
    <div>
      <Typography variant="h5" p={2}>All Profiles</Typography>
      <List>
        {profiles.map((profile) => (
          <ListItem button component={Link} to={`/profiles/${profile._id}`} key={profile._id}>
            <ListItemText primary={profile.name} secondary={profile.email} />
          </ListItem>
        ))}
      </List>
    </div>
  );
};

export default ProfilesList;