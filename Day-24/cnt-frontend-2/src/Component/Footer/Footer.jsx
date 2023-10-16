import React from "react";
import "../Footer/Footer.css";
import { useState } from "react";
import CopyrightIcon from '@mui/icons-material/Copyright';
import TwitterIcon from "@mui/icons-material/Twitter";
import InstagramIcon from "@mui/icons-material/Instagram";
import FacebookRoundedIcon from "@mui/icons-material/FacebookRounded";
import PhoneOutlinedIcon from "@mui/icons-material/PhoneOutlined";
import LocationOnOutlinedIcon from "@mui/icons-material/LocationOnOutlined";
import MarkunreadOutlinedIcon from "@mui/icons-material/MarkunreadOutlined";
import ReactCardFlip from "react-card-flip";
import { useNavigate } from "react-router-dom";
const Footer = () => {
  const [addShow, setAddShow] = useState(false);
  const [title, setTitle] = useState("");
  const [desc, setDesc] = useState("");
  const [error, setError] = useState(null);
  const [activeCard, setActiveCard] = useState(false);
  const navigate = useNavigate()

  const naviPrivacy = () =>{
    navigate("/privacy")
  }
  const naviFAQ = () =>{
    navigate("/faq")
  }
  const naviTAC = () =>{
    navigate("/tac")
  }
  const handleInsta = () =>{
    navigate("https://www.instagram.com/")
  }
  return (
    <>
      <div className="footer_Container">
        <div className="equalDivision1">
          <p1>About Our Company</p1>
          <hr />
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sagittis
            tristique nisi. Integer pharetra, velit vel laoreet tempus, felis
            nulla laoreet mauris, at convallis nisi quam quis risus. Sed odio
            nulla, pellentesque quis sollicitudin sit amet, hendrerit vel magna.
            Morbi laoreet imperdiet posuere. Suspendisse vitae suscipit eros,
            vitae convallis sem. Sed eu accumsan elit, non sollicitudin nulla.
            In sit amet justo molestie justo eleifend convallis. Mauris rhoncus
            lobortis tortor. Duis sit amet ipsum facilisis, varius metus mollis,
            blandit lorem. Cras hendrerit odio quis libero luctus, ac lobortis
            mauris rutrum. Donec vestibulum velit elit, nec convallis augue
            sollicitudin eu.
          </p>
        </div>
        <div className="equalDivision2">
          <span>Contact Us</span>
          <hr />
          <div className="locationIcon">
            <LocationOnOutlinedIcon />
            <p3>
              Mavericks Internet 1private Limited,
              <pre> Clove Embassy Tech Village,</pre>
              <pre>Outer Ring Road,</pre>
              Coimbatore 624009
            </p3>
            <div className="mailIcon">
              <MarkunreadOutlinedIcon />
              <p2>mavericks@gmail.com</p2>
            </div>
            <div className="phoneIcon">
              <PhoneOutlinedIcon />
              <p4>0444256987</p4>
            </div>
            
            <div className="socialMe">
            <p5>Also Availabe on:</p5>
              <br/>
              <div className="socialIconsFooter">
                <div className="icons00">
                  <FacebookRoundedIcon onClick={handleInsta}/>
                </div>
                <div className="icons00">
                  <InstagramIcon onClick={handleInsta}/>
                </div>
                <div className="icons00">
                  <TwitterIcon onClick={handleInsta}/>
                </div>
              </div>
            </div>
          </div>
        </div>
        {/* main */}
        <div className="equalDivision3">
          <hr />
          <span>Share Your Queries</span>
          {/* front */}
          <ReactCardFlip isFlipped={activeCard} flipDirection="vertical">
            <div className="create1">
              <form>
                <label>Add Email:</label>
                <input
                  type="text"
                  required
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                />
                <label>Add description of Your Query:</label>
                <textarea
                  required
                  value={desc}
                  type="text"
                  onChange={(e) => setDesc(e.target.value)}
                ></textarea>
                <button onClick={() => setActiveCard(!activeCard)}>
                  Submit
                </button>
              </form>
            </div>
            {/* back */}
            <div className="backclass">
              <p7>
                Thank you for submitting your query form. Your query has been
                received, and our team will review and sort it as soon as
                possible. You can expect a reply from us shortly.
              </p7>
              <button onClick={() => setActiveCard(!activeCard)}>Turn Over</button>
            </div>
          </ReactCardFlip>
        </div>

        <hr />
      </div>
      <div className="extra">
        <hr/>
        <div className="privacytag">
            <button onClick={naviPrivacy}>Privacy Policy</button>
            <button onClick={naviFAQ} className="faq">FAQ</button>
            <button onClick={naviTAC} className="tac">Terms Of Use</button>
           <p9>All rights reserved<CopyrightIcon/></p9>
        </div>
      </div>
    </>
  );
};

export default Footer;