import React, { useState } from 'react'
import axios from 'axios'
import { useEffect } from 'react'
import logo from "../../assets/logo.jpg"
import logo_dark from "../../assets/logo.jpg"
import "../Navbar/Navbar.css"
import { IoAdd, IoLogOut, IoMoon, IoSearch, IoSunny } from "react-icons/io5";
import { Flex, Image, Input, InputGroup, InputLeftElement, Menu, MenuButton, MenuItem, MenuList, useColorMode, useColorModeValue } from "@chakra-ui/react"
import { Link, useNavigate } from 'react-router-dom'
import { UseSelector, useSelector } from 'react-redux/es/hooks/useSelector';
import { selectuserr } from '../../Redux/userReducer';
import { persistor } from '../../Redux/Store'
import FileUploader from '../FileUploader'
import blank from '../../assets/blank_profile.png'
import { upload } from '@testing-library/user-event/dist/upload'


import { addImage, updateProfilepic, userDetail } from '../../service/api'


const Navbar = ({ user, setsearchTerm, searchTerm }) => {
  const navigate = useNavigate();
  const [showProfile, setShowProfile] = useState(false);
  const [showsavepic, setShowSavepic] = useState(false);
  const [showimagein, setShowImagein] = useState(false);
  const [userData, setUserData] = useState();
  const [addShow, setAddShow] = useState(false)
  const [dp, setDp] = useState('');
  const [desc, setDesc] = useState('');
  const [error, setError] = useState(null);
  const [file, setFile] = useState()
  const { colorMode, toggleColorMode } = useColorMode()
  const userr = useSelector(selectuserr)
  const bg = useColorModeValue("gray.600", "gray.300")
  const [imagecategory, setCategory] = useState('');
  const [imagecaption, setImageCaption] = useState("");
  const [imageurl, setImageUrl] = useState("");
  const [imagelikes, setImageLike] = useState(0);
  const [imagesave, setImageSave] = useState(false);
  const [showaddimg, setShowAddImage] = useState(false);
  const [userid, setUserId] = useState();
  const [imageData, setImageData] = useState();


  const imageset = {
    id: userData?.id,
    username: userData?.username,
    user: {
      id: userData?.id,
      username: userData?.username,
      email: userData?.email,
      password: userData?.password,
      code: userData?.code,
      profileurl: userData?.profileurl
    },
    images: [{
      imagecaption: imagecaption,
      imageurl: imageurl,
      category: imagecategory,
      likes: 0,
      saved: false,
      id: {
        id: userr?.id,
        username: userr?.username,
        email: userr?.email,
        password: userr?.password,
        code: userr?.code,
        profileurl: userr?.profileurl
      }
    }]
  };





  const logoutprofile = () => {
    persistor.purge();
    localStorage.clear();
    window.location.reload();
    navigate("/");
    
  }
  const loginprofile = () => {
    navigate("/login");
  }
  const handleChange = (e) => {
    if (e.target.value.length > 15) {
      setError("word limit is ksdbvjsbvebeiubvu")
      console.log(setError)
    }
    else {
      setDesc(e.target.value)
      setError(null)
    }
  }




  function handleFile(event) {
    setFile(event.target.files[0])
    console.log(file)
  }

//  const oneto =1;
  //<----------------------------------->\\


  useEffect(() => {
    // Make a request to fetch user information
    
    userDetail(userr ? userr.username : 'guest')
      .then((response) => {
        setUserData(response.data[0]);
        // const sampledata = userData.id.imageid;

        console.log(userr);
        console.log(imageset);

        console.log(response.data[0]?.profileurl.replaceAll("\"", ""));
        setUserId(response.data[0]?.id);

    // if(oneto===1)
    // {
    //   oneto =0;
    //   window.location.reload();
    // }

      })
      .catch((error) => {
        console.error('Error fetching user info:', error);
      });
  }, []);

  const UploadProfile = (e) => {
    e.preventDefault();
    updateProfilepic(userr ? userr.username : 'guest', dp)
      .then((res) => {
        console.log(userr.username)
        console.log(res.data);
        window.location.reload();
      }).catch((err) => {
        setShowSavepic(false);
        console.log('upload img', err)
      })

    console.log(dp)
  };
  const likes = 0;
  const saved = false;
  const handleUpload = (e) => {
    e.preventDefault();
    console.log(userData?.id);
    console.log(imageset);
    console.log(userData);
    addImage(imageset)
      .then((res) => {
        console.log(res.data);
        console.log(userr?.id);
        if (res.data === 'image added') {
          console.log('success');
        }
        window.location.reload();
      })

  }

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
              onFocus={() => navigate("/search")}
            />
          </InputGroup>

          <Flex justifyContent={"center"}
            alignItems="center">
            <div className="username_caption"> {userr ? userr?.username : "guest"} </div>
            {/* toggle btn */}
            <Flex
              margin-left={"10px"}
              width={"40px"}
              height="40px"
              justifyContent={"center"}
              alignItems="center"
              cursor={"pointer"}
              borderRadius="5px"
              onClick={toggleColorMode}
            >
              {colorMode == "light" ? (
                <IoSunny fontSize={25} />
              ) : (
                <IoMoon fontSize={25} />
              )}
            </Flex>
            {/* create Btn */}
            {(userData) &&
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
                onClick={() => { setAddShow(!addShow); setShowProfile(false); setShowImagein(false); setShowAddImage(false) }}
              />
            </Flex>

              }
            <Menu>
              <MenuButton onClick={() => { setShowProfile(!showProfile); { setShowImagein(false) }; setShowAddImage(false); setAddShow(false) }}>
                <Image
                  src={userData ? userData?.profileurl.replaceAll("\"", "") : blank}
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
            <div className='img_package'>
              <img className="profile_img" src={userData ? userData?.profileurl.replaceAll("\"", "") : blank} alt="imgplace" />
              <div className="editbutton"><button onClick={() => { setShowImagein(!showimagein); setShowSavepic(!showsavepic) }}>EDIT</button></div>

            </div>
            <div className="profile_detail">
              <div className="profile_name">NAME &nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;{userr ? userr?.username : "Guest"} </div>
              <div className="profile_email">EMAIL &nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;{userr ? userr?.email : "login "} </div>
              {userr ?
                <div className="logout"  ><button onClick={logoutprofile}>LOGOUT</button></div> :
                <div className="logout"  ><button onClick={loginprofile}>Login</button></div>
              }
            </div>
          </div>
        </div>
      }
      {
        showsavepic &&
        <div className="savepic"><button onClick={UploadProfile} > Save picture</button></div>
      }
      {showimagein &&
        <div className="imageupload-container">
          {
            <div className="uploaderbox">
              <FileUploader setImageUrl={setDp} />
            </div>
          }
        </div>
      }
      {addShow &&
        <div className="add_container">
          <div className="create">
            <h2>Add a New Post</h2>
            <form onSubmit={handleUpload}  >
              <label>Post title:</label>
              <input
                type="text"
                required
                value={imagecaption}
                onChange={(e) => setImageCaption(e.target.value)}
              />
              <label>Post description:</label>
              <textarea required value={desc} onChange={handleChange}>
                <span className='errorLimit'>{error && error}</span>
              </textarea>
              <label>Category:</label>
              <select value={imagecategory} required={true} onChange={(e) => setCategory(e.target.value)}>
                <option value="">Select</option>
                <option value="Games">Games</option>
                <option value="Funny">Funny</option>
                <option value="Technology">Technology</option>
                <option value="Nature">Nature</option>
                <option value="Animals">Animals</option>
                <option value="Movies">Movies</option>
              </select>
              <div className="uploadaddimg"><button className='upload-image-button' onClick={(e) => { { e.preventDefault(); setShowAddImage(!showaddimg) } }} >uploadImage</button></div>
              <button type='submit'>Upload</button>
            </form>
          </div>
        </div>
      }
      {showaddimg &&
        <div className="addimage-container">
          <div className="add-uploaderbox">
            <FileUploader setImageUrl={setImageUrl} />
          </div>
        </div>
      }
    </>

  )
}

export default Navbar