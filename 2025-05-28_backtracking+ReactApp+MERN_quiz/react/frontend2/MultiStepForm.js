import React, { useReducer } from 'react';
// import { formReducer, initialState } from './formReducer';
import Step1 from './Step1';
import Step2 from './Step2';
import Step3 from './Step3';
import Step4 from './Step4';
import axios from 'axios';

const initialState = {
  step: 1,
  name: '',
  email: '',
  phone: '',
  degree: '',
  institution: '',
  year: '',
  interests: '',
  achievements: '',
};

const formReducer = (state, action) => {
  switch (action.type) {
    case 'NEXT_STEP':
      return { ...state, step: state.step + 1 };
    case 'PREV_STEP':
      return { ...state, step: state.step - 1 };
    case 'UPDATE_FIELD':
      return { ...state, [action.field]: action.value };
    case 'RESET':
      return initialState;
    default:
      return state;
  }
};
const MultiStepForm = () => {
  const [state, dispatch] = useReducer(formReducer, initialState);

  const handleChange = (e) => {
    dispatch({ type: 'UPDATE_FIELD', field: e.target.name, value: e.target.value });
  };

  const handleSubmit = async () => {
    try {
      await axios.post('http://192.168.29.118:3000/profiles', state);
      dispatch({ type: 'RESET' });
      window.location.href = '/profiles';
    } catch (err) {
      console.error(err);
    }
  };

  const { step } = state;

  switch (step) {
    case 1:
      return <Step1 state={state} handleChange={handleChange} dispatch={dispatch} />;
    case 2:
      return <Step2 state={state} handleChange={handleChange} dispatch={dispatch} />;
    case 3:
      return <Step3 state={state} handleChange={handleChange} dispatch={dispatch} />;
    case 4:
      return <Step4 state={state} handleChange={handleChange} dispatch={dispatch} handleSubmit={handleSubmit} />;
    default:
      return <div>Invalid Step</div>;
  }
};

export default MultiStepForm;
