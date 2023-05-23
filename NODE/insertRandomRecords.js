'use strict';

const faker = require('faker');
const { Employee } = require('./models'); // Replace './models' with the correct path to your Employee model

async function insertRandomEmployees() {
  try {
    // Generate an array of 100 random employee objects
    const employees = [];
    for (let i = 0; i < 100; i++) {
      const employee = {
        fullName: faker.name.findName(),
        jobTitle: faker.name.jobTitle(),
        phoneNumber: faker.phone.phoneNumber(),
        email: faker.internet.email(),
        address: faker.address.streetAddress(),
        city: faker.address.city(),
        state: faker.address.state(),
        primaryEmergencyContact: faker.name.findName(),
        primaryEmergencyContactPhone: faker.phone.phoneNumber(),
        primaryEmergencyContactRelationship: faker.random.word(),
        secondaryEmergencyContact: faker.name.findName(),
        secondaryEmergencyContactPhone: faker.phone.phoneNumber(),
        secondaryEmergencyContactRelationship: faker.random.word(),
        createdAt: new Date(),
        updatedAt: new Date(),
      };
      employees.push(employee);
    }

    // Use Sequelize's bulkCreate method to insert all employees at once
    await Employee.bulkCreate(employees);

    console.log('Inserted 100 random employees successfully.');
  } catch (error) {
    console.error('Failed to insert random employees:', error);
  } finally {
    // Close the database connection if needed
    // Replace 'sequelize' with your Sequelize instance name
    await sequelize.close();
  }
}

insertRandomEmployees();
