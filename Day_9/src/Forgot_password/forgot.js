import "./forgot.css";
import { useState } from "react";
import axios from "axios";
import email from "../assets/email.png";
import password from "../assets/password.png";
import { useNavigate } from "react-router-dom";

function Forgot() {
  const [emailValue, setEmailValue] = useState("");
  const [codeValue, setCodeValue] = useState("");
  const [passwordValue, setPasswordValue] = useState("");
  const [confirmPasswordValue, setConfirmPasswordValue] = useState("");
  const [emailError, setEmailError] = useState("");
  const [codeError, setCodeError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");
  const [message, setMessage] = useState('');


  const navigate = useNavigate();

  const validateEmail = () => {
    const emailPattern = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i;

    if (!emailValue) {
      setEmailError("Please enter your email");
      return false;
    } else if (!emailPattern.test(emailValue)) {
      setEmailError("Invalid email address");
      return false;
    }

    setEmailError("");
    return true;
  };

  const validateCode = () => {
    if (!codeValue) {
      setCodeError("Please enter verification code");
      return false;
    }
    setCodeError("");
    return true;
  };

  const validatePassword = () => {
    const minLength = 6;
    const hasSymbol = /[!@#$%^&*()_+[\]{};':"\\|,.<>/?]+/;
    const hasNumber = /\d/;

    if (!passwordValue) {
      setPasswordError("Please enter your password");
      return false;
    } else if (passwordValue.length < minLength) {
      setPasswordError("Password must be at least 6 characters");
      return false;
    } else if (!hasSymbol.test(passwordValue)) {
      setPasswordError("Password must contain at least one symbol");
      return false;
    } else if (!hasNumber.test(passwordValue)) {
      setPasswordError("Password must contain at least one number");
      return false;
    }

    setPasswordError("");
    return true;
  };

  const validateConfirmPassword = () => {
    if (!confirmPasswordValue) {
      setConfirmPasswordError("Please confirm your password");
      return false;
    } else if (confirmPasswordValue !== passwordValue) {
      setConfirmPasswordError("Passwords do not match");
      return false;
    }

    setConfirmPasswordError("");
    return true;
  };

  const handleNext = () => {
    const isEmailValid = validateEmail();
    const isCodeValid = validateCode();
    if (isEmailValid && isCodeValid) {
      axios.get(`http://localhost:8080/checkcode/${emailValue}/${codeValue}`)
        .then((res) => {
          console.log(res.data);
          if (res.data === 'verified') {
            const container = document.getElementById("container");
            container.classList.add("right-panel-active");

          }
        })
    }
  };
  const handleCode = async (e) => {
    e.preventDefault();
    try {
      await axios.post(`http://localhost:8080/get-code/${emailValue}`);
      setMessage('Email sent successfully');
    } catch (error) {
      setMessage('Failed to send email');
    }
  };
  const handlePassword = () => {
    const isPasswordValid = validatePassword();
    const isConfirmPasswordValid = validateConfirmPassword();

    //  {
    axios.put(`http://localhost:8080/updatePassword/${emailValue}/${passwordValue}`)
      .then((res) => { console.log(res); })
    // navigate("/home");
    // }
  };

  return (
    <>
      <div className="doop">
        <div className="container" id="container">
          <div className="form-container email-container">
            <form action="#" className="email-verification-form" onSubmit={(e) => e.preventDefault()}>
              <h1 className="email_verification">Email verification</h1>
              <input
                type="email"
                placeholder="Email"
                value={emailValue}
                className="forgot_email"
                onChange={(e) => setEmailValue(e.target.value)}
                required
              />
              <button onClick={handleCode}> ok </button>
              <p>{message}</p>

              <span className="error-message-6">{emailError}</span>
              <input
                type="text"
                placeholder="Code"
                value={codeValue}
                className="forgot_code"
                onChange={(e) => setCodeValue(e.target.value)}
                required
              />
              <span className="error-message-7">{codeError}</span>
              <span className="code_text">Resend Code</span>
              <button
                className="next_button"
                id="nextButton"
                type="button"
                onClick={handleNext}
              >
                Next
              </button>
            </form>
          </div>

          <div className="form-container password-container">
            <form action="#" className="reset-password-form" onSubmit={(e) => e.preventDefault()}>
              <h1 className="reset_password">Reset your password</h1>
              <input
                type="text"
                placeholder="Enter your new Password"
                value={passwordValue}
                className="password_first"
                onChange={(e) => setPasswordValue(e.target.value)}
                required
              />
              <span className="error-message-8">{passwordError}</span>
              <input
                type="password"
                placeholder="Confirm your Password"
                value={confirmPasswordValue}
                className="confirm_password"
                onChange={(e) => setConfirmPasswordValue(e.target.value)}
                required
              />
              <span className="error-message-9">{confirmPasswordError}</span>
              <button
                className="change_button"
                type="button"
                onClick={handlePassword}
              >
                Change password
              </button>
            </form>
          </div>
          <div className="overlay-container">
            <div className="overlay">
              <div className="overlay-panel overlay-left">
                <img src={password} alt="password logo" />
                <span className="span_text">
                  Please type your new password with at least 6 characters, 1
                  symbol, and 1 number
                </span>
              </div>
              <div className="overlay-panel overlay-right">
                <img src={email} alt="email logo" />
                <span className="span_text">
                  The verification code has been sent to your registered email
                </span>
              </div>
            </div>
          </div>
        </div>
        <div className="background-image"></div>
      </div>
    </>
  );
}

export default Forgot;
