// import { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './Login_Register/login';
import Forgot from './Forgot_password/forgot';

function App() {
	return (
        <BrowserRouter>
          <Routes>
          <Route
              path='/'
              element=
              {
                <>
                  <Login />
                </>
              }
          />
          <Route
              path='/forgot'
              element=
              {
                <>
                  <Forgot />
                </>
              }
          />
          </Routes>
        </BrowserRouter>
  )
  }
  
export default App;