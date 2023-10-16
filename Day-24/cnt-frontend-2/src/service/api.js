import axios from "axios";




let jwtToken = localStorage.getItem('Token')

console.log(jwtToken);


const authheader = `Bearer ${jwtToken}`;
const headers = {
  'Authorization': authheader,
  'Content-Type': 'application/json',
};

const URI = 'http://localhost:8080'



// storing data in local storage
const getUserDetail =(nameValue)=>axios.get('http://localhost:8080/api/auth/getdetail/'+nameValue)



//Login and Signup
const userRegister = (username,password,email,code,profileurl,role) => axios.post(`${URI}/api/auth/register`,{username,password,email,code,profileurl,role})
const userLogin=(username,password)=> axios.post(`${URI}/api/auth/authenticate`,{username,password} )

// EMAIL forget password
const getCode =(email)=>axios.post(`http://localhost:8080/api/auth/get-code/${email}`)
const checkCode=(email,code)=>   axios.get(`http://localhost:8080/api/auth/checkcode/${email}/${code}`)
const changePassword=(email,password,code)=>axios.put(`http://localhost:8080/api/auth/changepassword/${code}/${password}/${email}`,{code:code})

//Navbar
  //updateprofile
  const updateProfilepic =(userr,dp)=> axios.get(`http://localhost:8080/api/auth/login/update-image/${userr}`, { params: { dp: dp } })
  //add image
  const addImage=(imageset)=> axios.post(`http://localhost:8080/image_user/postimagesbyuser`, imageset)
  const userDetail = async (user) => await axios.get(`http://localhost:8080/api/auth/getdetail/${user}`)
  


  const TdeleteUser = async (id) => await axios.delete(`http://localhost:8080/api/admin/deletedata/${id}`,{headers})
  const banUserB =(userName,isactive)=>axios.put(`http://localhost:8080/api/admin/updateActiveStatus`,{userName:userName,isactive:isactive},{headers})
  

















export {userRegister,userLogin,checkCode,getCode,changePassword,getUserDetail,updateProfilepic,addImage,userDetail,TdeleteUser,banUserB};