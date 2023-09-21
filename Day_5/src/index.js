import React from 'react';
import ReactDOM from "react-dom";
import App from './App';
import { BrowserRouter as Router } from "react-router-dom";
import { ChakraProvider, ColorModeScript } from '@chakra-ui/react'
import {theme} from "./Component/Navbar/theme"
import { Provider } from 'react-redux';
ReactDOM.render(
  
    <ChakraProvider>
      <ColorModeScript initialColorMode={theme.config.initialColorMode} />
      <Router>
        <App />
      </Router>
    </ChakraProvider>,
    document.getElementById("root")
  );
