import React from 'react'

const Employee = ({employee ,deleteEmployee}) => {
   
  return (
    <tr key={employee.id}>
       
                <td className='text-left px-6 py-4 whitespace-nowrap'>
                    <div className='text-sm text-gray-500'>{employee.firstName}</div>
                </td>
                <td className='text-left px-6 py-4 whitespace-nowrap'>
                    <div className='text-sm text-gray-500'>{employee.lastName}</div>
                </td>
                <td className='text-left px-6 py-4 whitespace-nowrap'>
                    <div className='text-sm text-gray-500'>{employee.emailId}</div>
                </td>
                <td className='text-right px-6 py-4 whitespace-nowrap font-medium text-sm'>
                    <a  
                  
                    className='text-indigo-600 hover:text-indigo-900 px-4 hover:cursor-pointer'>Edit</a>
                    <a  
                    className='text-indigo-600 hover:text-indigo-900   hover: cursor-pointer'
                    onClick={ (e,id)=>deleteEmployee(e,employee.id)}
                    
                    >Delete</a>
                </td>
            </tr>
  )
}

export default Employee