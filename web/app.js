
const rideForm = document.getElementById("rideForm");

rideForm.addEventListener("submit", async function (event) {
    event.preventDefault();

    const result = document.getElementById("result");

    const pickup = document.getElementById("pickup").value.trim();
    const destination =
        document.getElementById("destination").value.trim();

    if (!pickup || !destination) {
        return;
    }

    result.classList.remove("d-none", "alert-danger");
    result.classList.add("alert-info");
    result.textContent = "Connecting to Java backend...";

    try {
        const response = await fetch("/api/rides", {
            method: "POST"
        });

        const message = await response.text();

        if (!response.ok) {
            throw new Error(message || "Request failed");
        }

        result.textContent = message;
    } catch (error) {
        result.classList.remove("alert-info");
        result.classList.add("alert-danger");
        result.textContent =
            "Could not connect. Open RideNow through the Java server.";
        console.error(error);
    }
});
