import React, { useEffect } from "react";
import "./MainPage.css";
import { FaTwitter } from "react-icons/fa";
import { motion } from "framer-motion";
import Navbar from "../Navbar/Navbar";
import { categories } from "../Category/data";
import Category from "../Category/Category";
import axios from "axios";
import { useState } from "react";
import Heart_OutLine from "../../assets/heart-outline.png";
import Heart_Full from "../../assets/heart-full.png";

import save_OutLine from "../../assets/save-outline.png";
import { useNavigate,Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { login, selectuserr } from "../../Redux/userReducer";
import Swal from 'sweetalert2';



function MainPage() {
  const [imageData, setImageData] = useState([]);
  const navigate = useNavigate();
  const [videoLikes, setVideoLikes] = useState(Array(imageData.length).fill(false));
  const [likes, setLikes] = useState(0);
  const [imageid, setimageId] = useState(0);
const dispatch = useDispatch();
const user = useSelector(selectuserr)
  const toggleVideoLike = (imageid) => {
    // const updatedLikes = [...videoLikes];
    // updatedLikes[imageid] = !updatedLikes[imageid];
    // setVideoLikes(updatedLikes);
    try {
      axios.put(`http://localhost:8080/permitall/updateimage/likes/${imageid}/${user.username}`).then((res)=>{
        console.log(res);
        axios.get('http://localhost:8080/api/auth/getdetail/'+user.username).then((res)=>{
          dispatch(login(res.data[0]));
          console.log(user);
        })
        axios.get('http://localhost:8080/permitall/image/data')
        .then((response) => {
          setImageData(response.data);
          setLikes(response.data[0].likes);
          setimageId(response.data[0]?.imageid);
          console.log(response.data[0]?.likes);
          console.log(response.data);
        })
        .catch((error) => {
          console.error('Error in fetching image detail', error)
        });
      })
    } catch
    {
      console.log("error in likes");
      Swal.fire({
        icon: 'error',
        title: 'Login to like',
        text: ' click ok to login', 
        showConfirmButton: true,  
        showCancelButton:true
      }).then((result)=>{
        if(result.isConfirmed)
        {
          navigate("/login");
        }
      })
    }
    
  };
  const onMove = () => {
    navigate("/myuploads");
  }
  useEffect(() => {
    axios.get('http://localhost:8080/permitall/image/data')
      .then((response) => {
        setImageData(response.data);
        // setLikes(response.data[0].likes);
        setimageId(response.data[0]?.imageid);
        console.log(response.data[0]?.likes);
        console.log(response.data);
      })
      .catch((error) => {
        console.error
        
        
        ('Error in fetching image detail', error);
      });
  }, []);
  const handleFilter=(data)=>{
    localStorage.setItem("category",data);
    navigate("/filtercategory");
  }

  return (
    <>

      <div className="main-container">
        <div className="categories-container">
          {categories.map((data) => (
            <button onClick={()=>handleFilter(data.name)}><Category key={data.id} data={data} /></button>
          ))}
          {(localStorage.getItem("Role")==="ADMIN") ?
          <div ><button onClick={onMove} ></button></div>:
          <div ><button onClick={onMove} >my uploads</button></div>
          }
        </div>
        <div className="content-container">
          <div className="MainPage-page">
            {/* <span className="MainPage_Video_Title">Trending Images</span> */}
            <motion.div className="MainPageVideo-page">
              {imageData.map((mainpage, index) => (
                <motion.div
                  layout
                  key={mainpage.imageid}
                  className="MainPage-Video-div"
                >
                  <img
                    className="MainPage-Video-img"
                    src={mainpage?.imageurl}
                    alt=""
                  />
                  <div className="MainPage_Like_Save">
                    <img
                      src={(user?.likes?.find(id=>id===mainpage.imageid)) ? Heart_Full : Heart_OutLine}
                      alt="Heart"
                      className="MainPage_Video_like"
                      onClick={() => toggleVideoLike(mainpage.imageid)}
                    />
                    <div className="liketext">{mainpage?.likes} likes </div>
                    <img
                      src={save_OutLine}
                      alt="Save"
                      className="MainPage_Video_save"
                    // onClick={() => toggleVideoSave(mainpage.id)}
                    />
                  </div>
                  <div className="post_profile_section">
                    <img
                      src={mainpage?.id?.profileurl}
                      alt=""
                      className="MainPage-Video-profile-pic"
                    />
                    <div className="MainPage-Video-caption">
                      {mainpage.imagecaption}
                    </div>
                    <div className="MainPage-Video-username">
                      By {mainpage.id?.username}
                    </div>
                  </div>

                </motion.div>
              ))}
            </motion.div>
          </div>
        </div>
      </div>

    </>

  );
}

export default MainPage;
