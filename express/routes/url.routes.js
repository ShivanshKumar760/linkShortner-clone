import express from "express";
import { Router } from "express";
import * as c from "../controller/url.controller.js";
const router = Router();
router.post("/shorten", c.shorten);
router.get("/:code", c.redirect);
router.get("/qr/:code", c.downloadQr);
export default router;
