import { Wrapper } from "../Wrapper";

describe("Word Wrap Should", () => {

  describe("Exception handling",()=>{
    it("Returns an empty string if the text is not received", () => {
      let wrapper=new Wrapper();
      expect(wrapper.wrap("",4)).toBe("");
    });

  });
});