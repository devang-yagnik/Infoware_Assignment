const express = require("express");
const app = express();
const bodyParser = require("body-parser");
app.use(bodyParser.json());
const path = require("path");
const { Employee } = require("./models"); // Make sure to import the Employee model correctly

// Add employee
app.post('/addEmployee', async (req, res) => {
  try {
    const emp = await Employee.addEmployee(req.body);
    res.json(emp);
  } catch (error) {
    res.status(500).json({ error: 'Failed to add employee' });
  }
});

// Get all employees with count
app.get('/getEmployees', async (req, res) => {
  try {
    // Retrieve the employees
    const employees = await Employee.findAll();

    res.json({
      count: employees.length,
      employees
    });
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: 'Failed to retrieve employees' });
  }
});


// Get employees by page
app.get('/getEmployees/:offset/:pageSize', async (req, res) => {
  const { offset, pageSize } = req.params;
  try {
    const employees = await Employee.getEmployeesPage(parseInt(offset), parseInt(pageSize));
    res.json({
      count: employees.length,
      employees
    });
  } catch (error) {
    res.status(500).json({ error: 'Failed to retrieve employees' });
  }
});

// Get employee by ID
app.get('/getEmployee/:id', async (req, res) => {
  const { id } = req.params;
  try {
    const emp = await Employee.getEmployeeById(id);
    if (emp) {
      res.json(emp);
    } else {
      res.status(404).json({ error: 'Employee not found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Failed to retrieve employee' });
  }
});

// Update employee
app.put('/updateEmployee/:id', async (req, res) => {
  const { id } = req.params;
  try {
    const updatedFields = req.body;
    const emp = await Employee.updateEmployee(id, updatedFields);
    if (emp[0] === 1) {
      res.json({ message: 'Employee updated successfully' });
    } else {
      res.status(404).json({ error: 'Employee not found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Failed to update employee' });
  }
});

// Delete employee
app.delete('/deleteEmployee/:id', async (req, res) => {
  const { id } = req.params;
  try {
    const emp = await Employee.deleteEmployee(id);
    if (emp === 1) {
      res.json({ message: 'Employee deleted successfully' });
    } else {
      res.status(404).json({ error: 'Employee not found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Failed to delete employee' });
  }
});

app.listen(8080, (err) => {
  if (err)
    console.log(err);
  else
    console.log('Listening at port 8080');
});
