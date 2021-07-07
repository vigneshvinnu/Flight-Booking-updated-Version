import { fireEvent, render } from "@testing-library/react";
import BookingForm from "./BookingForm";
import React from "react";
import ReviewForm from "../Review/ReviewForm";

it("checkButtonRender1", () => {
  const { queryByTitle } = render(<BookingForm />);
  expect(queryByTitle("bookingform")).toBeTruthy();
});

it("checkButtonRender2", () => {
  const { queryByTitle } = render(<BookingForm />);
  expect(queryByTitle("save")).toBeTruthy();
});

it("checkButtonRender3", () => {
  const { queryByTitle } = render(<BookingForm />);
  expect(queryByTitle("save")).toBeTruthy();
});

it("checkButtonRender4", () => {
  const { queryByTitle } = render(<BookingForm />);
  expect(queryByTitle("bookingform")).toBeTruthy();
});

it("checkButtonRender5", () => {
  const { queryByPlaceholderText } = render(<BookingForm />);
  expect(queryByPlaceholderText("age")).toBeTruthy();
});

it("checkButtonRender6", () => {
  const { queryByPlaceholderText } = render(<BookingForm />);
  expect(queryByPlaceholderText("Last Name")).toBeTruthy();
});

it("checkButtonRender7", () => {
  const { queryByPlaceholderText } = render(<BookingForm />);
  expect(queryByPlaceholderText("First Name")).toBeTruthy();
});

it("checkButtonRender8", () => {
  const { queryByTitle } = render(<BookingForm />);
  expect(queryByTitle("Age")).toBeTruthy();
});

it("checkButtonRender9", () => {
  const { queryByTitle } = render(<BookingForm />);
  expect(queryByTitle("Last Name")).toBeTruthy();
});

it("checkButtonRender10", () => {
  const { queryByTitle } = render(<BookingForm />);
  expect(queryByTitle("First Name")).toBeTruthy();
});

it("checkButtonRender11", () => {
  const { queryByPlaceholderText } = render(<BookingForm />);
  expect(queryByPlaceholderText("save")).toBeTruthy();
});

it("checkButtonRender12", () => {
  const { queryByPlaceholderText } = render(<BookingForm />);
  expect(queryByPlaceholderText("cancel")).toBeTruthy();
});

describe("Cancel value", () => {
  it("updates on change", () => {
    const { queryByPlaceholderText } = render(<BookingForm />);
    const cancelInput = queryByPlaceholderText("cancel");
    fireEvent.change(cancelInput, { target: { value: "test" } });
    expect(cancelInput.value).toBe("test");
  });
});

describe("Save value", () => {
  it("updates on change", () => {
    const { queryByPlaceholderText } = render(<BookingForm />);
    const saveInput = queryByPlaceholderText("save");
    fireEvent.change(saveInput, { target: { value: "test" } });
    expect(saveInput.value).toBe("test");
  });
});

describe("Age value", () => {
  it("updates on change", () => {
    const { queryByPlaceholderText } = render(<BookingForm />);
    const ageInput = queryByPlaceholderText("age");
    fireEvent.change(ageInput, { target: { value: 20 } });
    expect(ageInput.value).toBe("20");
  });
});

describe("LastName value", () => {
  it("updates on change", () => {
    const { queryByPlaceholderText } = render(<BookingForm />);
    const ageInput = queryByPlaceholderText("Last Name");
    fireEvent.change(ageInput, { target: { value: "vinnu" } });
    expect(ageInput.value).toBe("vinnu");
  });
});

describe("FirstName value", () => {
  it("updates on change", () => {
    const { queryByPlaceholderText } = render(<BookingForm />);
    const ageInput = queryByPlaceholderText("First Name");
    fireEvent.change(ageInput, { target: { value: "vinnu" } });
    expect(ageInput.value).toBe("vinnu");
  });
});

describe("Booking form", () => {
  describe("Query on Booking Form", () => {
    it("trigger", () => {
      const Search = jest.fn();
      const { queryByTitle } = render(<BookingForm Search={Search} />);
      fireEvent.click(queryByTitle("save"));
      expect(Search).not.toHaveBeenCalled();
    });
  });
});

it("checkButtonRender19", () => {
    const { queryByTestId } = render(<ReviewForm />);
    expect(queryByTestId("submit")).toBeTruthy();
  });

it("checkButtonRender20", () => {
    const { queryByTitle } = render(<ReviewForm />);
    expect(queryByTitle("username")).toBeTruthy();
});

it("checkButtonRender21", () => {
    const { queryByTestId } = render(<ReviewForm />);
    expect(queryByTestId("submit")).toBeTruthy();
  });

it("checkButtonRender22", () => {
    const { queryByTitle } = render(<ReviewForm />);
    expect(queryByTitle("feedback")).toBeTruthy();
});  

describe("username value", () => {
    it("username on change", () => {
      const { queryByPlaceholderText } = render(<ReviewForm />);
      const ageInput = queryByPlaceholderText("Feedback");
      fireEvent.change(ageInput, { target: { value: "vinnu" } });
      expect(ageInput.value).toBe("vinnu");
    });
  });

describe("feedback value", () => {
    it("feedback on change", () => {
      const { queryByPlaceholderText } = render(<ReviewForm />);
      const ageInput = queryByPlaceholderText("Feedback");
      fireEvent.change(ageInput, { target: { value: "vinnu" } });
      expect(ageInput.value).toBe("vinnu");
    });
  });


  describe("submit value", () => {
    it("submit on change", () => {
      const { queryByPlaceholderText } = render(<ReviewForm />);
      const ageInput = queryByPlaceholderText("submit");
      fireEvent.change(ageInput, { target: { value: "vinnu" } });
      expect(ageInput.value).toBe("vinnu");
    });
  });




  it("checkButtonRender100", () => {
    const { queryByTitle } = render(<BookingForm />);
    expect(queryByTitle("Age1")).not.toBeTruthy();
  });
  
  it("checkButtonRender102", () => {
    const { queryByTitle } = render(<BookingForm />);
    expect(queryByTitle("Last Name1")).not.toBeTruthy();
  });
  
  it("checkButtonRender103", () => {
    const { queryByTitle } = render(<BookingForm />);
    expect(queryByTitle("First Name1")).not.toBeTruthy();
  });
  
  it("checkButtonRender104", () => {
    const { queryByPlaceholderText } = render(<BookingForm />);
    expect(queryByPlaceholderText("save1")).not.toBeTruthy();
  });
  
  it("checkButtonRender105", () => {
    const { queryByPlaceholderText } = render(<BookingForm />);
    expect(queryByPlaceholderText("cancel1")).not.toBeTruthy();
  });
  
  describe("Cancel value1", () => {
    it("updates on change", () => {
      const { queryByPlaceholderText } = render(<BookingForm />);
      const cancelInput = queryByPlaceholderText("cancel");
      fireEvent.change(cancelInput, { target: { value: "test" } });
      expect(cancelInput.value).not.toBe("test1");
    });
  });
  
  describe("Save value1", () => {
    it("updates on change", () => {
      const { queryByPlaceholderText } = render(<BookingForm />);
      const saveInput = queryByPlaceholderText("save");
      fireEvent.change(saveInput, { target: { value: "test" } });
      expect(saveInput.value).not.toBe("test1");
    });
  });
  
  describe("Age value1", () => {
    it("updates on change", () => {
      const { queryByPlaceholderText } = render(<BookingForm />);
      const ageInput = queryByPlaceholderText("age");
      fireEvent.change(ageInput, { target: { value: 20 } });
      expect(ageInput.value).not.toBe("40");
    });
  });
  
  describe("LastName value1", () => {
    it("updates on change", () => {
      const { queryByPlaceholderText } = render(<BookingForm />);
      const ageInput = queryByPlaceholderText("Last Name");
      fireEvent.change(ageInput, { target: { value: "vinnu" } });
      expect(ageInput.value).not.toBe("vinnu1");
    });
  });
  
  describe("FirstName value1", () => {
    it("updates on change", () => {
      const { queryByPlaceholderText } = render(<BookingForm />);
      const ageInput = queryByPlaceholderText("First Name");
      fireEvent.change(ageInput, { target: { value: "vinnu" } });
      expect(ageInput.value).not.toBe("vinnu1");
    });
  });
  
  describe("Booking form1", () => {
    describe("Query on Booking Form", () => {
      it("trigger", () => {
        const Search = jest.fn();
        const { queryByTitle } = render(<BookingForm Search={Search} />);
        fireEvent.click(queryByTitle("save"));
        expect(Search).not.toHaveBeenCalled();
      });
    });
  });
  
  it("checkButtonRender106", () => {
      const { queryByTestId } = render(<ReviewForm />);
      expect(queryByTestId("submit1")).not.toBeTruthy();
    });
  
  it("checkButtonRender107", () => {
      const { queryByTitle } = render(<ReviewForm />);
      expect(queryByTitle("username1")).not.toBeTruthy();
  });
  
  it("checkButtonRender108", () => {
      const { queryByTestId } = render(<ReviewForm />);
      expect(queryByTestId("submit1")).not.toBeTruthy();
    });
  
  it("checkButtonRender109", () => {
      const { queryByTitle } = render(<ReviewForm />);
      expect(queryByTitle("feedback1")).not.toBeTruthy();
  });  
  
  describe("username value1", () => {
      it("username on change", () => {
        const { queryByPlaceholderText } = render(<ReviewForm />);
        const ageInput = queryByPlaceholderText("Feedback");
        fireEvent.change(ageInput, { target: { value: "vinnu" } });
        expect(ageInput.value).not.toBe("vinnu1");
      });
    });
  
  describe("feedback value1", () => {
      it("feedback on change", () => {
        const { queryByPlaceholderText } = render(<ReviewForm />);
        const ageInput = queryByPlaceholderText("Feedback");
        fireEvent.change(ageInput, { target: { value: "vinnu" } });
        expect(ageInput.value).not.toBe("vinnu1");
      });
    });
  
  
    describe("submit value1", () => {
      it("submit on change", () => {
        const { queryByPlaceholderText } = render(<ReviewForm />);
        const ageInput = queryByPlaceholderText("submit");
        fireEvent.change(ageInput, { target: { value: "vinnu" } });
        expect(ageInput.value).not.toBe("vinnu1");
      });
    });
  


jest.mock("react-router", () => ({
  withRouter: jest.fn((Comp) => (props) => <Comp {...props} />),
}));
