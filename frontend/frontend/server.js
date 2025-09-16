document
  .getElementById("encryptionForm")
  .addEventListener("submit", async function (event) {
    event.preventDefault();

    const message = document.getElementById("message").value;

    const response = await fetch("http://localhost:8080/otp/encrypt", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ message: message }),
    });

    if (response.ok) {
      const data = await response.json();
      document.getElementById("originalMessage").textContent =
        data.originalMessage;
      document.getElementById("key").textContent = data.key;
      document.getElementById("encryptedMessage").textContent =
        data.encryptedMessage;

      document.getElementById("result").classList.remove("hidden");
    } else {
      alert("Error encrypting message.");
    }
  });
