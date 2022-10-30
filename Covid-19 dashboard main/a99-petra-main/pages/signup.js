import React, { useEffect, useState } from "react";
import { Page } from "../components/Page";
import { SignupBox } from "../components/SignupBox"

export default function Main() {
  return (
    <Page layout="1">
      <SignupBox></SignupBox>
    </Page>
  );
}