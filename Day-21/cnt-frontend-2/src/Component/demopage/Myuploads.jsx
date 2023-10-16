import React, { useEffect, useState } from 'react'
import { FaTwitter } from "react-icons/fa";
import { motion } from "framer-motion";
import Navbar from "../Navbar/Navbar";
import { categories } from "../Category/data";
import Category from "../Category/Category";
import axios from "axios";
import Heart_OutLine from "../../assets/heart-outline.png";
import { UseSelector, useSelector } from 'react-redux/es/hooks/useSelector';
import { selectuserr } from '../../Redux/userReducer';

import save_OutLine from "../../assets/save-outline.png";
const Myuploads = () => {
    const[userData2,setuserData2]=useState();
    const[usernamehere,setUsernameHere]=useState();
    const[imageData2,setimageData2]=useState();
    const userr = useSelector(selectuserr);

    useEffect(() => {
        // Make a request to fetch user information
        axios.get(`http://localhost:8080/permitall/getdetail/${userr ? userr.username : 'guest'}`)
          .then((response) => {
            setuserData2(response.data[0]);
            setUsernameHere(response.data[0]?.id);
    
            console.log(userData2.id);
            
          })
          .catch((error) => {
            console.error('Error fetching user info:', error);
          });
      }, []);
    useEffect(()=>{
        axios.get(`http://localhost:8080/permitall/${userr.username}/getAll`)
        .then((res)=>
        {
            setimageData2(res.data);
             console.log(imageData2);
        })
    },[])
  return (
    <>
      <div className="main-container">
        <div className="categories-container">
          {categories.map((data) => (
            <Category key={data.id} data={data} />
          ))}
          <div ><button>my uploads</button></div>
        </div>
        <div className="content-container">
        <div className="MainPage-page">
        <motion.div className="MainPageVideo-page">
          {imageData2&&
          imageData2.map((main) => (
            <motion.div
              layout
              key={main.imageid}
              className="MainPage-Video-div"
            >
              <img
                className="MainPage-Video-img"
                src={main.imageurl}
                alt="imageurl`"
              />
              <div className="post_profile_section">
                <img
                  src={main?.id?.profileurl}
                  alt="here"
                  className="MainPage-Video-profile-pic"
                />
                <div className="MainPage-Video-caption">
                  {main?.imagecaption}
                </div>
                {/* <div className="MainPage-Video-username">
                  By {mainpage.username}
                </div> */}
              </div>
              
            </motion.div>
          ))}
        </motion.div>
        </div>
      </div>
      </div>

    </>
  )
}

export default Myuploads