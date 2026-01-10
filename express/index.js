import express from "express";
import cors from "cors";
import urlRoutes from "./routes/url.routes.js";
import { mongooseInstance } from "./db/mongoose.js";
const app = express();
const PORT = 8080;
app.use(cors());
app.use(express.json());
app.use("/", urlRoutes);

const startServer = async () => {
  try {
    await mongooseInstance();
    app.listen(PORT, () => {
      console.log(`Server is running on http://localhost:${PORT}`);
    });
  } catch (error) {
    console.error("Failed to start server:", error);
  }
};

startServer();
