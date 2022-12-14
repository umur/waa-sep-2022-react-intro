import React from "react";
import { Link } from "react-router-dom";

export default function CreateCourse() {

  const submit = () => {
    alert("submit");
  }

  return (
    <>
      <p></p>
      <div className="container">
        {/* Content here  */}
        <div style={{ display: "flex", justifyContent: "space-between" }}>
          {/* <a href="index.html" type="button" className="btn btn-success">Home</a> */}
          <Link to='/dashboard' type="button" className="btn btn-success">Dashboard</Link>
          {/* <a href="course.html" type="button" className="btn btn-primary">Course</a> */}
          <Link to='/course' type="button" className="btn btn-primary">Course</Link>
          {/* <a href="student.html" type="button" className="btn btn-secondary">Student</a> */}
          <Link to='/srudent' type="button" className="btn btn-secondary">Student</Link>
        </div>
        <p>Add Course</p>
        <hr />
        <form>
          <div className="form-group">
            <label>ID</label>
            <input type="number" className="form-control" id="id" placeholder="Enter ID" />
            <label>Name</label>
            <input type="text" className="form-control" id="name" placeholder="Enter Name" />
          </div>
          <div className="form-group">
            <label>Code</label>
            <input type="text" className="form-control" id="code" placeholder="Enter Code" />
          </div>
          <a onClick={submit} type="button" className="btn btn-success">Submit</a>
        </form>
      </div>
    </>
  )
}