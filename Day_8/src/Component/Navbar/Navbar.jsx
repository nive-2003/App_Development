import React, { useState } from 'react'
import axios from 'axios'
import { useEffect } from 'react'
import logo from "../../assets/logo.jpg"
import logo_dark from "../../assets/logo.jpg"
import "../Navbar/Navbar.css"
import { IoAdd, IoLogOut, IoMoon, IoSearch, IoSunny } from "react-icons/io5";
import { Flex, Image, Input, InputGroup, InputLeftElement, Menu, MenuButton, MenuItem, MenuList, useColorMode, useColorModeValue } from "@chakra-ui/react"
import { Link,useNavigate } from 'react-router-dom'
import { UseSelector, useSelector } from 'react-redux/es/hooks/useSelector';
import { selectuserr } from '../../Redux/userReducer';
import demopic from "../../assets/demopic.jpg"



const Navbar = ({user, setsearchTerm, searchTerm}) => {
  const navigate = useNavigate();
  const [showProfile,setShowProfile]=useState(false);
  const { colorMode, toggleColorMode } = useColorMode()
  const bg = useColorModeValue("gray.600","gray.300")
  const [userData, setUserData] = useState();
  const userr = useSelector(selectuserr)
  //<----------------------------------->
  const[addShow,setAddShow] = useState(false)
  const [title, setTitle] = useState('');
    const [desc, setDesc] = useState('');
  const [category, setCategory] = useState('Games');
  const[error,setError] = useState(null)
  const handleChange = (e) => {
    if(e.target.value.length > 3){
        setError("word limit is ksdbvjsbvebeiubvu")
        console.log(setError)
    }
    else{
        setDesc(e.target.value)
        setError(null)
    }
  }


  //file Upload
  const [file,setFile] = useState()

  function handleFile(event){
    setFile(event.target.files[0])
    console.log(file)
  }

  function handleUpload(){
    const formData = new FormData()
    formData.append('file',file)
    fetch(
      'url',{
        method:"POST",
        body: formData
      }
    ).then((response)=>response.json().then(
      (result) => {
        console.log('success',result)
      }
    ).catch(error =>{
      console.error("Error:",error)
    }))
  }
  //<=---------------------------------->
 

  useEffect(() => {
    // Make a request to fetch user information
    axios.get(`http://localhost:8080/getdetail/${userr?userr.username : 'guest'}`)
        .then((response) => {
            setUserData(response.data[0]);

        })
        .catch((error) => {
            console.error('Error fetching user info:', error);
        });
}, []);

  return (
    <>
    <div className="navbar-bigbox">

    
  <Flex
    justifyContent={"space-between"}
    alignItems="center"
    width={"97vw"}
    overflow={"hidden"}
    p={4}
  >
    <Link to={"/"}>
      <div className="logopic"><Image src={colorMode == "light" ? logo_dark : logo} borderRadius={"50px"} width={"80px"} /></div>
    </Link>

    <InputGroup mx={6} width="60vw">
      <InputLeftElement
        pointerEvents="none"
        children={<IoSearch fontSize={25} />}
      />
      <Input
        type="text"
        placeholder="Search..."
        fontSize={18}
        fontWeight="medium"
        variant={"filled"}
        value={searchTerm}
        onChange={(e) => setsearchTerm(e.target.value)}
        // onFocus={() => navigate("/search")}
      />
    </InputGroup>

    <Flex justifyContent={"center"}
    alignItems="center">
      <div className="username_caption"> {userr ? userr.username : "guest"} </div>
      {/* toggle btn */}
      <Flex
        width={"40px"}
        height="40px"
        justifyContent={"center"}
        alignItems="center"
        cursor={"pointer"}
        borderRadius="5px"
        onClick={toggleColorMode}
        // right={"210px"}
        // position={"absolute"}
        
      >
        {colorMode == "light" ? (
          <IoMoon fontSize={25} />
        ) : (
          <IoSunny fontSize={25} />
        )}
      </Flex>
      

      {/* create Btn */}
        <Flex
          justifyContent={"center"}
          alignItems="center"
          bg={bg}
          width="40px"
          height="40px"
          borderRadius="5px"
          mx={6}
          cursor="pointer"
          _hover={{ shadow: "lg" }}
          transition="ease-in-out"
          transitionDuration={"0.3s"}
        >
          <IoAdd
            fontSize={25}
            color={`${colorMode == "dark" ? "#111" : "#f1f1f1"}`}
            onClick={()=>{setAddShow(!addShow)}}
            />
        </Flex>

      <Menu>
        <MenuButton onClick={()=>setShowProfile(!showProfile)}>
          <Image
            src={logo}
            width="40px"
            height="40px"
            minWidth={"40px"}
            rounded="full"
          />
        </MenuButton>
      </Menu>
    </Flex>
  </Flex>
  </div>
  {showProfile &&
  <div className="profile_container">
    <div className="profile_box">
      <div className="profile_img"><img src={logo} alt="imgplace" /></div>
      <div className="profile_detail">
        <div className="profile_name">NAME &nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;{userData?.username} </div>
        <div className="profile_email">EMAIL &nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;{userData.email} </div>
        <div className="logout">LOGOUT</div>
      </div>
    </div>
  </div>
  }
  {addShow &&
  <div className="add_container">
  <div className="create">
  <h2>Add a New Post</h2>
  <form>
    <label>Post title:</label>
    <input 
      type="text" 
      required 
      value={title}
      onChange={(e) => setTitle(e.target.value)}
    />
    <label>Post description:</label>
    <textarea
      required
      value={desc}
      onChange={handleChange}
    >
        <span className='errorLimit'>{error && error}</span>
    </textarea>
    <label>Category:</label>
    <select
      value={category}
      onChange={(e) => setCategory(e.target.value)}
    >
      <option value="Games">Games</option>
      <option value="Funny">Funny</option>
      <option value="Technology">Technology</option>
      <option value="Nature">Nature</option>
      <option value="Animals">Animals</option>
    </select>
    <form onSubmit={handleUpload}>
    <label>Image Upload:</label>
    <input onChange={handleFile} type="file"/>
    <button >Upload</button>
    </form>
  </form>
</div>
</div>
}

  </>
   
  )
}

export default Navbar