import React from 'react'
import Navbar from './Navbar/Navbar'
import{categories}from "../Component/data"
import Category from './Category'
const Home = () => {
  return (
   <>
   <Navbar/>
   {categories &&
            categories.map((data) => <Category key={data.id} data={data} />)}
   </>
  )
}

export default Home