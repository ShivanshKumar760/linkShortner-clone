import mongoose from "mongoose";

const mongooseInstance = async () => {
  await mongoose.connect("mongodb://127.0.0.1:27017/url_shortener"); //this actually returns a promise
  console.log("Connected to MongoDB");
};

export { mongooseInstance };
