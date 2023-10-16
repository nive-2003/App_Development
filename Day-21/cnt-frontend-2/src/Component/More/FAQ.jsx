import React from "react";
import "../More/Privacy.css";
import ReactCardFlip from "react-card-flip";
import { useState } from "react";
const FAQ = () => {
  const [activeCard1, setActiveCard1] = useState(false);
  const [activeCard2, setActiveCard2] = useState(false);
  const [activeCard3, setActiveCard3] = useState(false);
  const [activeCard4, setActiveCard4] = useState(false);
  const [activeCard5, setActiveCard5] = useState(false);
  const [activeCard6, setActiveCard6] = useState(false);
  return (
    <>
      <div className="mainFAQ">
        <div class="cardFAQ">
          <div class="card__contentFAQ">
            <h1>FAQ</h1>
            <div className="divisionFaq1">
              {/* front */}
              <ReactCardFlip isFlipped={activeCard1} flipDirection="vertical">
                <div className="faqFront1">
                  <p1>What should I do if I forgot my username?</p1>
                  <button onClick={() => setActiveCard1(!activeCard1)}>
                    Click Me!
                  </button>
                </div>
                {/* back */}
                <div className="faqBack1">
                  <p11>
                    -Visit the Login Page
                    <br />
                    -Click "Forgot Password."
                    <br />
                    - Enter your email and password
                    <br />
                    -Check your email for reset code.
                    <br />
                    -Create a new password.
                    <br />
                    -Log in with the new password.
                  </p11>
                  <button onClick={() => setActiveCard1(!activeCard1)}>
                    Turn Over
                  </button>
                </div>
              </ReactCardFlip>
            </div>
            <div className="divisionFaq2">
              {/* front */}
              <ReactCardFlip isFlipped={activeCard2} flipDirection="vertical">
                <div className="faqFront2">
                  <p1>How do I edit my profile photo?</p1>
                  <button onClick={() => setActiveCard2(!activeCard2)}>
                    Click Me!
                  </button>
                </div>
                {/* back */}
                <div className="faqBack2">
                  <p11>
                    -Go to your profile.
                    <br />
                    - Tap your current profile photo.
                    <br />
                    - Choose "Edit Profile Picture." <br />
                    - Pick a new photo from your gallery. <br />- Then tap
                    "Done" to save.
                  </p11>
                  <button onClick={() => setActiveCard2(!activeCard2)}>
                    Turn Over
                  </button>
                </div>
              </ReactCardFlip>
            </div>
            <div className="divisionFaq3">
              {/* front */}
              <ReactCardFlip isFlipped={activeCard3} flipDirection="vertical">
                <div className="faqFront3">
                  <p1>How can I report a bug or technical issue?</p1>
                  <button onClick={() => setActiveCard3(!activeCard3)}>
                    Click Me!
                  </button>
                </div>
                {/* back */}
                <div className="faqBack3">
                  <p11>
                    -Go to footer page.
                    <br />
                    - Enter you mail.
                    <br />
                    - Add a brief description about your issue. <br />
                    - Tap submit button <br />- Our team will respond you back
                    within 2-3 days.
                  </p11>
                  <button onClick={() => setActiveCard3(!activeCard3)}>
                    Turn Over
                  </button>
                </div>
              </ReactCardFlip>
            </div>
            <div className="divisionFaq4">
              {/* front */}
              <ReactCardFlip isFlipped={activeCard4} flipDirection="vertical">
                <div className="faqFront4">
                  <p1>Is Mavericks safe for kids and teenagers?</p1>
                  <button onClick={() => setActiveCard4(!activeCard4)}>
                    Click Me!
                  </button>
                </div>
                {/* back */}
                <div className="faqBack4">
                  <p11>
                    "Our website is designed to be a safe and welcoming space
                    for users of all ages. We prioritize online safety by
                    implementing stringent security measures, monitoring for
                    inappropriate content, and adhering to industry best
                    practices. We're committed to providing a positive and
                    secure experience for every visitor, ensuring their peace of
                    mind while exploring our platform."
                  </p11>
                  <button onClick={() => setActiveCard4(!activeCard4)}>
                    Turn Over
                  </button>
                </div>
              </ReactCardFlip>
            </div>
            <div className="divisionFaq5">
              {/* front */}
              <ReactCardFlip isFlipped={activeCard5} flipDirection="horizontal">
                <div className="faqFront5">
                  <p1>How should i post content in a specific category?</p1>
                  <button onClick={() => setActiveCard5(!activeCard5)}>
                    Click Me!
                  </button>
                </div>
                {/* back */}
                <div className="faqBack5">
                  <p11>
                   -Click the plus button in navbar<br/>
                   -Type the title of your post<br/>
                   -Fill out the post description of your content/Post<br/>
                   -Now select the category in which your content falls into<br/>
                   -Upload the content<br/>
                   -Select Upload button to post successfully
                  </p11>
                  <button onClick={() => setActiveCard5(!activeCard5)}>
                    Turn Over
                  </button>
                </div>
              </ReactCardFlip>
            </div>
            <div className="divisionFaq6">
              {/* front */}
              <ReactCardFlip isFlipped={activeCard6} flipDirection="horizontal">
                <div className="faqFront6">
                  <p1>How should i post content in a specific category?</p1>
                  <button onClick={() => setActiveCard6(!activeCard6)}>
                    Click Me!
                  </button>
                </div>
                {/* back */}
                <div className="faqBack6">
                  <p11>
                   -Click the plus button in navbar<br/>
                   -Type the title of your post<br/>
                   -Fill out the post description of your content/Post<br/>
                   -Now select the category in which your content falls into<br/>
                   -Upload the content<br/>
                   -Select Upload button to post successfully
                  </p11>
                  <button onClick={() => setActiveCard6(!activeCard6)}>
                    Turn Over
                  </button>
                </div>
              </ReactCardFlip>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default FAQ;