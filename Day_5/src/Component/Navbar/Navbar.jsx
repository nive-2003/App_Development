import React from 'react'
import logo from "../logo.jpg"
import logo_dark from "../logo.jpg"
import { IoAdd, IoLogOut, IoMoon, IoSearch, IoSunny } from "react-icons/io5";
import { Flex, Image, Input, InputGroup, InputLeftElement, Menu, MenuButton, MenuItem, MenuList, useColorMode, useColorModeValue } from "@chakra-ui/react"
import { Link,useNavigate } from 'react-router-dom'

const Navbar = ({user, setsearchTerm, searchTerm}) => {
  const navigate = useNavigate();
  const { colorMode, toggleColorMode } = useColorMode()
  const bg = useColorModeValue("gray.600","gray.300")
  
  return (<Flex
    justifyContent={"space-between"}
    alignItems="center"
    width={"100vw"}
    p={4}
  >
    <Link to={"/"}>
      <Image src={colorMode == "light" ? logo_dark : logo} borderRadius={"50px"}
      width={"80px"} />
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
      <Link to={"/create"}>
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
          />
        </Flex>
      </Link>

      <Menu>
        <MenuButton>
          <Image
            src={logo}
            width="40px"
            height="40px"
            minWidth={"40px"}
            rounded="full"
          />
        </MenuButton>
        <MenuList shadow={"lg"}>
          <Link to={`/userDetail/${user?.uid}`}>
            <MenuItem>My Account</MenuItem>
          </Link>
          <MenuItem
            flexDirection={"row"}
            alignItems="center"
            gap={4}
            onClick={() => {
              localStorage.clear();
              navigate("/login", { replace: true });
            }}
          >
            Logout <IoLogOut fontSize={20} />
          </MenuItem>
        </MenuList>
      </Menu>
    </Flex>
  </Flex>
   
  )
}

export default Navbar