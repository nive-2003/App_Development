import React, { useState } from "react";
import "./Details.css";
import Obito_Profile from "../assets/obito_profile.jpg";
import { motion } from "framer-motion";
import { categories } from "../Component/Category/data";
import Category from "../Component/Category/Category";
import axios from "axios";
import { useEffect } from "react";
import DeleteTwoToneIcon from '@mui/icons-material/DeleteTwoTone';
import VisibilityTwoToneIcon from '@mui/icons-material/VisibilityTwoTone';
const Details=()=> {
  const [users, setUsers] = useState([]);
useEffect(() => {
  loadUsers();
}, []);
const loadUsers = async () => {
  const result = await axios.get("http://localhost:8080/getdata");
  console.log(result);
  setUsers(result.data);
};
const deleteUser = async(id)=>{
  await axios.delete(`http://localhost:8080/deletedata/${id}`)
  loadUsers()
}
  return (
    <>
      <div className="container-admin">
        <div className="categories-container-admin">
          {categories.map((data) => (
            <Category key={data.id} data={data} />
          ))}
        </div>
        <div className="content-container-admin">
          <div className="MainPage-page-admin">
            {/* Video section */}
            <span className="MainPage_Video_Title-admin">Logged In User Details</span>
            <motion.div className="MainPageVideo-page-admin">
              {users.map((user, index) => (
                <motion.div
                  layout
                  key={index}
                  className="MainPage-Video-div-admin"
                >
                   <img
                    className="MainPage-Video-img-admin"
                    src="https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510_640.jpg"
                    alt=""
                  /> 
                  <div className="post_profile_section-admin">
                    {/* <img
                      src={Obito_Profile}
                      alt=""
                      className="MainPage-Video-profile-pic-admin"
                    /> */}
                    <div className="MainPage-Video-caption-admin">
                     Email: {user.email}
                    </div>
                    <div className="MainPage-Video-username-admin">
                      UserName: {user.username}
                      <br/>
                    </div>
                      <div className="deleteUser">
                      <DeleteTwoToneIcon onClick={()=>deleteUser(user.id)} />
                      </div>
                      <div className="viewUser">
                      <VisibilityTwoToneIcon />
                      </div>
                    </div>
                </motion.div>
              ))}
            </motion.div>
            {/* Video section */}
          </div>
        </div>
      </div>
      
    </>
  );
}

export default Details;

// {/* <span className="MainPage_Image_Title">Trending Images</span>

// <div className="MainPageImage-slider">
//   <motion.div className="MainPageImage-page">
//     {imageData.map((mainImage, index) => (
//       <motion.div
//         key={index}
//         className={`MainPage-Image-div ${
//           index === activeSlide ? "active" : ""
//         }`}
//       >
//         <img
//           className="MainPage-Image-img"
//           src={mainImage.MainPageUrl}
//           alt=""
//         />
//         <div className="MainPage_Like_Save">
//           <img
//             src={imageLikes[index] ? Heart_Full : Heart_OutLine}
//             alt="Heart"
//             className="MainPage_Image_like"
//             onClick={() => toggleImageLike(index)}
//           />
//           <img
//             src={imageSaves[index] ? save_Full : save_OutLine}
//             alt="Save"
//             className="MainPage_Image_save"
//             onClick={() => toggleImageSave(index)}
//           />
//         </div>
//         <div className="post_profile_section">
//           <img
//             src={Obito_Profile}
//             alt=""
//             className="MainPage-Image-profile-pic"
//           />
//           <div className="MainPage-Image-caption">
//             {mainImage.MainPageCaption}
//           </div>
//           <div className="MainPage-Image-username">
//             By {mainImage.MainUsername}
//           </div>
//         </div>
//       </motion.div>
//     ))}
//   </motion.div>
// </div>

// {/* slider control for image */}
// {/* <div className="img-slider-controls">
//   <img
//     src={left_arrow}
//     alt="left_arrow"
//     onClick={scrollLeft}
//     className="img-slider-control left"
//   />
//   <img
//     src={right_arrow}
//     alt="right_arrow"
//     onClick={scrollRight}
//     className="img-slider-control right"
//   />
// </div>
// {/* slider control for image */}

// {/* Image section */}

// // {/* <div className="separator-line"></div> */} */} */}
