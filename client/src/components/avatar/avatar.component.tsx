import { StyledImg } from './avatar.styled';
// interface AvatarProps {}
export const Avatar: React.FC<{
  size?: 'sm' | 'xs' | 'md' | 'lg';
  name?: string;
  ringColor?: string;
  className?: string;
}> = () => {
  return (
    <>
      <StyledImg />
      <img
        src="https://img.freepik.com/free-vector/beautiful-girl-with-clouds-kawaii-character_24877-52665.jpg?w=2000"
        alt="avatar icon"
        className="rounded-full w-[70px] h-[70px] object-cover my-3 ring-2 ring-indigo-500"
      />
    </>
  );
};

// import { AiFillStar } from 'react-icons/ai';
// import { FaRegGrinStars } from 'react-icons/fa';
// import { BiLogoKickstarter } from 'react-icons/bi';
// const AvatarImage = () => {
//   return (
//     <>
//       {/* flex */}

//       {/* Image container */}

//       <div className="flex gap-3 items-center">
//         <div className="h-12 w-12 overflow-hidden rounded-full">
//           <img
//             src="https://scontent.fcai19-6.fna.fbcdn.net/v/t39.30808-6/362936274_840075417789003_6244302275898563897_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=a2f6c7&_nc_ohc=iPI54Nb-d8IAX9MpExs&_nc_ht=scontent.fcai19-6.fna&oh=00_AfCKhQs-X1Y-03twhoef4KBcJtHESViwKHqP5KINInmG-g&oe=651715BA"
//             alt="img"
//             className="w-full h-full object-cover"
//           />
//         </div>

//         <div>
//           <h3 className="text-xl font-medium uppercase">Muhammad Hamdy</h3>
//           <div className="flex gap-2 items-center">
//             <span className="text-sky-400 uppercase text-sm">
//               Platform Founders
//             </span>

//             <AiFillStar />
//             {/* <FaRegGrinStars className="text-green-400" />
//             <span className="text-green-400 uppercase text-sm">Expert</span> */}
//             {/* <BiLogoKickstarter className="text-purple-400" />
//             <span className="text-purple-400 uppercase text-sm">Verified</span> */}
//           </div>
//         </div>
//       </div>
//     </>
//   );
// };

// export const Avatar = () => {};
