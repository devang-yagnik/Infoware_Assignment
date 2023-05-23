'use strict';
const { Model } = require('sequelize');

module.exports = (sequelize, DataTypes) => {
  class Employee extends Model {
    static associate(models) {
      // define association here
    }

    static addEmployee(emp) {
      return Employee.create(emp);
    }

    static getEmployees() {
      return Employee.findAll();
    }

    static getEmployeesPage(offset, pageSize) {
      return Employee.findAll({
        offset,
        limit: pageSize
      });
    }

    static getEmployeeById(id) {
      return Employee.findByPk(id);
    }

    static deleteEmployee(id) {
      return Employee.destroy({ where: { id } });
    }

    static updateEmployee(id, updatedFields) {
      return Employee.update(updatedFields, { where: { id } });
    }
  }

  Employee.init(
    {
      fullName: DataTypes.STRING,
      jobTitle: DataTypes.STRING,
      phoneNumber: DataTypes.STRING,
      email: DataTypes.STRING,
      address: DataTypes.STRING,
      city: DataTypes.STRING,
      state: DataTypes.STRING,
      primaryEmergencyContact: DataTypes.STRING,
      primaryEmergencyContactPhone: DataTypes.STRING,
      primaryEmergencyContactRelationship: DataTypes.STRING,
      secondaryEmergencyContact: DataTypes.STRING,
      secondaryEmergencyContactPhone: DataTypes.STRING,
      secondaryEmergencyContactRelationship: DataTypes.STRING,
    },
    {
      sequelize,
      modelName: 'Employee',
      underscored: false,
    }
  );

  return Employee;
};
