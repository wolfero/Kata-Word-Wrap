import { Wrapper } from "../Wrapper";

describe("Word Wrap Should", () => {
  describe("Exception handling", () => {
    it("Returns an empty string if the text is not received", () => {
      let wrapper = new Wrapper();
      expect(wrapper.wrap("", 4)).toBe("");
    });
    it("Negative numbers are not allowed", () => {
      let wrapper = new Wrapper();
      expect(() => wrapper.wrap("test", -4)).toThrowError(
        "Negative numbers are not allowed"
      );
    });
    it("Zero are not allowed", () => {
      let wrapper = new Wrapper();
      expect(() => wrapper.wrap("test", 0)).toThrowError(
        "Zero are not allowed"
      );
    });
  });
  describe("Execution", () => {
    it("Returns wrapped string if given the correct format of string and a number", () => {
      let wrapper = new Wrapper();
      expect(wrapper.wrap("test", 3)).toBe("tes\nt");
    });
  });
});
