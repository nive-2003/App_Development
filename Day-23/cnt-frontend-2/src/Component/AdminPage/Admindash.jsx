import React, { useState } from "react";
import "./Admindash.css"
import Obito_Profile from "../../assets/logo.jpg";
import { motion } from "framer-motion";
import { categories_admin } from "./categories_admin";
import Category from "../Category/Category";
// import { VideoData } from "../Homepage/data";
import axios from "axios";
import { useEffect } from "react";
import { TdeleteUser, banUserB } from "../../service/api";
import { useNavigate } from "react-router-dom";

const Admindash = () => {
  const [users, setUsers] = useState([]);
  const [showviewdet,setShowViewDet]=useState(false);
  const [isactivenum, setIsActiveNum] = useState(0);
  const navigate = useNavigate(); 


  useEffect(() => {
    loadUsers();
  }, []);


  const deleteUser = async (id) => {
    await TdeleteUser(id)
    loadUsers();
  }
  const banData={
    
    userName:users.username,
    isactive:isactivenum
  }
  
  
  const banUser=(user)=>{
    // const isactivenum = users.isactive ? 0 : 1
    // console.log(user);
    // console.log(isactivenum);
    try{
    banUserB(user,0)
    .then((res)=>{
      console.log("a");
      loadUsers();
    })
  }catch{
    console.log("b");
  }
  }
  const UnbanUser=(user)=>{
    // const isactivenum = users.isactive ? 0 : 1
    // console.log(user);
    // console.log(isactivenum);
    try{
    banUserB(user,1)
    .then((res)=>{
      console.log("a");
      loadUsers();
    })
  }catch{
    console.log("b");
  }
  }

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/api/admin/getdata");
    console.log(result);
    setUsers(result.data);
  };
  const userPost=(data)=>{
    
  }
  const allActiveUser=()=>{
    loadUsers();
  }
  const allBannedUser=()=>{
    axios.get(`http://localhost:8080/api/admin/getUserOfBan`).
    then((res)=>{
       setUsers(res.data)
      console.log(res);
    })
  }
  return (
    <>
      <div className="container-admin">
        <div className="categories-container-admin">
          {categories_admin.map((data) => (
            <button><Category key={data.id} data={data} /></button>
          ))}
          <div className="AllUserbutton"><button onClick={allActiveUser}>Active Users</button></div>
          <br/>
          <div className="banbutton"><button onClick={allBannedUser}>BannedUsers</button></div>
        </div>
        <div className="content-container-admin">
          <div className="Page-page-admin">
            
            <span className="MainPage_Video_Title">All Users</span>
            <motion.div className="PageVideo-page-admin">
              {users.map((user, index) => (
                <motion.div className="Page-Video-div-admin">
                  <img
                    key={index}
                    src={user.profileurl}
                    alt="profile_photo"
                    className="profile_photo_admin"
                  />
                  <div className="Page-Video-useremail-admin">{user.email}</div>
                  <div className="Page-Video-username-admin">
                    {user.username}
                  </div>
                  <div className="Page-Video-Delete-View">
                    {user.isactive ?
                    <button className="delete_button_admin" onClick={() => banUser(user.username)} >Ban User</button> :
                    <button className="delete_button_admin" onClick={() => UnbanUser(user.username)} >Unban User</button> 
                    }
                    <button className="view_button_admin" onClick={()=>setShowViewDet(!showviewdet)}>View Post</button>
                  </div>
                </motion.div>
              ))}
            </motion.div>
          </div>
        </div>
      </div>
      {showviewdet &&
      <div className="viewcontainer">
        sdvdfv
      </div>
      }
    </>
  )
}

export default Admindash