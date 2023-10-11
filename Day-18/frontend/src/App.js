// import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Login_Register/login';
import Forgot from './Forgot_password/forgot';
import Navbar from './Component/Navbar/Navbar';
import MainPage from './Component/Homepage/MainPage';
import { ChakraProvider, ColorModeScript, theme } from '@chakra-ui/react';
import Footer from './Footer/Footer';
import Privacy from './More/Privacy';
import FAQ from './More/FAQ';
import TAC from './More/TAC';
import Details from './AdminPage/Details';

function App() {
	return (
   
        <Router>
          <Routes>
          <Route path="/Login" element= {<><Login /></>}/>
          <Route path="/" element= {<><ChakraProvider> <ColorModeScript initialColorMode={theme.config.initialColorMode}/><Navbar /> <MainPage /><Footer/>
          </ChakraProvider></>}/>
          <Route path="/forgot" element= {<><Forgot /></>}/>
          <Route path="/privacy" element= {<><Privacy/></>}/>
          <Route path="/faq" element= {<><FAQ/></>}/>
          <Route path="/tac" element= {<><TAC/></>}/>
          <Route path="/details" element= {<><ChakraProvider> <ColorModeScript initialColorMode={theme.config.initialColorMode}/><Navbar /> <Details />
          </ChakraProvider></>}/>
          </Routes>
        </Router>
        
  )
  }
  
export default App;